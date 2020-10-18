import java.util.ArrayList;
/**
 * The judge and Distributor class checks the winner of a game and consequently
 * distributes money to the winner and takes money from the losers
 */
public class JudgeAndDistributor {
    private Player dealer;
    public JudgeAndDistributor(Player dealer) {
        this.dealer = dealer;
    }
    /**
     * Check if a player/dealer's total value went over 21
     */
    public void bust(Player player) {
        ArrayList<Hand> hands = new ArrayList<Hand>();
        hands = player.getHands();
        for (int i = 0; i < hands.size(); i++) {
            int value = hands.get(i).getTotalValue();
            if (value > 21) {
                hands.get(i).setStatus(false);
                System.out.println("Player "
                            + player.getPlayerIndex()
                            +" hand " + i + " is BUST!");
                hands.get(i).setBust();
            } else if (value == 21) {
                System.out.println("Player "
                            + player.getPlayerIndex()
                            +" hand " + i + " hit BlackJack!");
                hands.get(i).setStatus(false);
            }
        }
    }

    /**
     * Checks the winner of a blackjack game. Player who has the higher value
     * under 21 wins. In the case of a tie @ 21, natural black jack wins. In 
     * the case of a tie @ any other number, bet is returned. 
     */
    public void checkWinner(ArrayList<Player> players) {
        Hand dealerHand = dealer.getHands().get(0);
        int dealerValue = dealerHand.getTotalValue();
        if (dealerValue > 21) {
            for (Player player : players) {
                for (Hand hand : player.getHands()) {
                    if (!hand.bust()) {
                        this.distributor(player, true);
                    } else {
                        // Player busts before dealer, player loses and out
                        // for the round, and will not get compensation for
                        // dealer busts
                        this.distributor(player, false);
                    }
                }
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
                    } else {
                        this.distributor(player, false);
                    }
                }
            }
        }
    }
    /**
     * Distributes money
     */
    public void distributor(Player player, boolean win) {
        int bet = player.getCurrentBet();
        if (win) {
            System.out.println("Player " + player.getPlayerIndex() 
                                + " wins " + 2*bet + " dollars!");
            player.winOrLose(2*bet);
            dealer.winOrLose(-(2*bet));
        } else {
            System.out.println("Player " + player.getPlayerIndex() 
                                + " loses " + bet + " dollars!");
            player.winOrLose(-bet);
            dealer.winOrLose(bet);
        }
    }
}
