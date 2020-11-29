package games.blackjack;

import java.util.ArrayList;

import games.*;
import structure.cards.Card;
import structure.participant.*;
import structure.table.CardGameTable;
import utilities.*;
/**
 *  The BlackJack class stores the actual game flow. It executes the game of 
 *  black jack when called
 */
public class BlackJackGame extends SumCardGame {
    public static String name = 
        TextColors.ANSI_GREEN 
        + "BlackJack" 
        + TextColors.ANSI_RESET;

    private Dealer dealer;
    private ArrayList<Player> players;
    private CardGameTable blackJackTable;
    public BlackJackGame(CardGameTable table) {
        super(table);
        blackJackTable = getTable();
        players = blackJackTable.getPlayers().getPlayers();
        dealer = blackJackTable.getPlayers().getDealer();
    }

    /**
     * The body of the game
     */

    @Override
    public void startRound() {
         // Deal two rounds of card
         for (int i = 0; i < 2; i++) {
            System.out.println("The dealer will now deal a round of cards for every player on the table");
            for (Player player : players) {
                Card card = blackJackTable.getNextCard();
                card.flipCard(true);
                blackJackTable.dealCard(player.getHands().get(0), card);
                if (isWin(player.getHands().get(0))) {
                    player.getHands().get(0).setStatus(false);
                }
            }
            Card card = blackJackTable.getNextCard();
            if (i < 1) {
                card.flipCard(true);
            } else {
                card.flipCard(false);
            }
            blackJackTable.dealCard(dealer.getHand(), card);
            System.out.println(blackJackTable);
            Input.pressEnter();
        }
    }
    

    @Override
    public void playerMove(Player player, PlayerHand hand) {
        int max = 3, input = 0;
        System.out.println(player.getName() + ", please choose what to do for current hand");
        System.out.print("0: view cards, 1: hit, 2: stand, 3: double up");
        if (isDouble(hand)) {
            max = 4;
            System.out.println(", 4: split");
        }
        System.out.print("\n");
        boolean done = false;
        while (!done) {
            done = true;
            input = Input.integerInput(0, max);
            switch(input) {
                case 0: System.out.println(hand); done = false; break;
                case 1: hit(hand); break;
                case 2: stand(hand); break;
                case 3: doubleUp(hand); break;
                case 4: split(player, hand); break;
            }
        }
    }

     /**
     * Player doubles bet, then hit and stand
     */
    private void doubleUp(PlayerHand hand) {
        hand.setBet(hand.getBet() * 2);
        hit(hand);
        stand(hand);
    }

    /**
     * Player splits into two hands. The two hands will move independently
     */
    private void split(Player player, Hand hand) {
        //player.split(hand);
        int bet = ((PlayerHand) hand).getBet();
        ArrayList<Card> cards = hand.getCards();
        cards.remove(cards.size() - 1);

        PlayerHand newHand = new PlayerHand(bet);
        for (Card card : cards) {
            newHand.addCard(card);
        }
        player.getHands().add(newHand);
        hit(hand);
        hit(newHand);
    }

    private boolean isDouble(Hand hand) {
        ArrayList<Card> cards = hand.getCards();
        if (cards.size() >= 2) {
            Card card1 = cards.get(cards.size() - 1);
            Card card2 = cards.get(cards.size() - 2);
            return card1.getType().equals(card2.getType());
        } else {
            return false;
        }
    }

    @Override
    public void tie(Player player, Dealer dealer, PlayerHand hand) {
        System.out.println("Game is tie between PLAYER: " + player.getName() + " and DEALER: " + dealer.getName());
    }

    @Override
    public void win(Player player, Dealer dealer, PlayerHand hand) {
        System.out.println(player.getName() + " won " + 2*hand.getBet());
        distribute(player, dealer, 2*hand.getBet());
    }

    @Override
    public void lose(Player player, Dealer dealer, PlayerHand hand) {
        System.out.println(player.getName() + " lost " + hand.getBet());
        distribute(player, dealer, -hand.getBet());
    }
}
