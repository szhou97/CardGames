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
            if (hands.get(i).getTotalValue() > 21) {
                hands.get(i).setStatus(false);
                System.out.println("Player "
                            + player.getPlayerIndex()
                            +" hand "
                            + hands.get(i).getIndex()
                            + " is BUST!");
                hands.get(i).setBust();
                this.distributor(player, false);
            } else if (hands.get(i).getTotalValue() == 21) {
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
        for (Player player : players) {
            for (Hand hand : player.getHands()) {
                if (hand.bust()) {
                    continue;
                }
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
                        System.out.println("Draw! Bet returned to player");
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
    }
}
