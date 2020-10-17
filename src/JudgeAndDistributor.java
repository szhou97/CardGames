import java.util.ArrayList;

public class JudgeAndDistributor {
    private Player dealer;
    public JudgeAndDistributor(Player dealer) {
        this.dealer = dealer;
    }

    public void bust(Player player) {
        ArrayList<Hand> hands = new ArrayList<Hand>();
        hands = player.getHands();
        for (int i = 0; i < hands.size(); i++) {
            int value = hands.get(i).getTotalValue();
            System.out.println(value);
            if (value > 21) {
                hands.get(i).setStatus(false);
                System.out.println("Player "
                            + player.getPlayerIndex()
                            +" hand "
                            + hands.get(i).getIndex()
                            + " is BUST!");
                hands.get(i).setBust();
                this.distributor(player, false);
            } else if (value == 21) {
                System.out.println("Player "
                            + player.getPlayerIndex()
                            +" hand "
                            + hands.get(i).getIndex()
                            + " hit BlackJack!");
                hands.get(i).setStatus(false);
            }
        }
    }

    public void checkWinner(ArrayList<Player> players) {
        Hand dealerHand = dealer.getHands().get(0);
        int dealerValue = dealerHand.getTotalValue();
        System.out.println("Dealer's card sum is  " + dealerValue);
        if (dealerValue > 21) {
            for (Player player : players) {
                this.distributor(player, true);
            }
        } else {
            for (Player player : players) {
                for (Hand hand : player.getHands()) {
                    if (!hand.bust()) {
                        int playerValue = hand.getTotalValue();
                        if (playerValue < dealerValue) {
                            this.distributor(player, false);
                        } else if (playerValue > dealerValue){
                            this.distributor(player, true);
                        } else {
                            if (hand.isNaturalBlackJack() && !dealerHand.isNaturalBlackJack()) {
                                this.distributor(player, true);
                            } else if (!hand.isNaturalBlackJack() && dealerHand.isNaturalBlackJack()) {
                                this.distributor(player, false);
                            } else {
                                System.out.println("Draw! Bet returned to player " 
                                                    + player.getPlayerIndex());
                            }
                        }
                    }
                }
            }
        }
    }
    public void distributor(Player player, boolean win) {
        int dealerBalance = dealer.getBalance();
        int bet = player.getCurrentBet();
        int playerBalance = player.getBalance();
        if (win) {
            System.out.println("Player " + player.getPlayerIndex() 
                                + " wins " + 2*bet + " dollars!");
            player.setBalance(playerBalance + 2 * bet);
            dealer.setBalance(dealerBalance - 2 * bet);
        } else {
            System.out.println("Player " + player.getPlayerIndex() 
                                + " loses " + bet + " dollars!");
            player.setBalance(playerBalance - bet);
            dealer.setBalance(dealerBalance + bet);
        }
        player.setTotal();
        dealer.setTotal();
    }
}
