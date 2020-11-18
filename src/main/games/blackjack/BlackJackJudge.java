package games.blackjack;

import java.util.ArrayList;

import participant.Player;
/**
 * The judge and Distributor class checks the winner of a game and consequently
 * distributes money to the winner and takes money from the losers
 */
public class BlackJackJudge {
    /**
     * Check if a player/dealer's total value went over 21
     */
    public static void bust(Player player) {
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
    public static void checkWinner(Player dealer, ArrayList<Player> players) {
        Hand dealerHand = dealer.getHands().get(0);
        int dealerValue = dealerHand.getTotalValue();
        if (dealerValue > 21) {
            for (Player player : players) {
                for (Hand hand : player.getHands()) {
                    if (!hand.bust()) {
                        Distributor.distribute(player, dealer, true);
                    } else {
                        // Player busts before dealer, player loses and out
                        // for the round, and will not get compensation for
                        // dealer busts
                        Distributor.distribute(player, dealer, false);
                    }
                }
            }
        } else {
            for (Player player : players) {
                for (Hand hand : player.getHands()) {
                    if (!hand.bust()) {
                        int playerValue = hand.getTotalValue();
                        if (playerValue < dealerValue) {
                            Distributor.distribute(player, dealer, false);
                        } else if (playerValue > dealerValue){
                            Distributor.distribute(player, dealer, true);
                        } else {
                            if (hand.isNaturalBlackJack() && !dealerHand.isNaturalBlackJack()) {
                                Distributor.distribute(player, dealer, true);
                            } else if (!hand.isNaturalBlackJack() && dealerHand.isNaturalBlackJack()) {
                                Distributor.distribute(player, dealer, false);
                            } else {
                                System.out.println("Draw! Bet returned to player " 
                                                    + player.getPlayerIndex());
                            }
                        }
                    } else {
                        Distributor.distribute(player, dealer, false);
                    }
                }
            }
        }
    }
    
    
}
