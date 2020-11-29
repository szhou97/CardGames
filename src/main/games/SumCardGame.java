/******************************************************************************
 * Class: SumCardGames
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/

package games;

import java.util.ArrayList;

import games.blackjack.BlackJackGame;
import games.blackjack.BlackJackRules;
import games.trianta.TriantaEnaGame;
import games.trianta.TriantaEnaRules;
import structure.cards.Card;
import structure.participant.*;
import structure.table.CardGameTable;
import utilities.Input;

/**
 * SumCardGames is the parent class for any card game that aims to reach a 
 * certain number such as BlackJack(21) and TriantaEna(31). It contains the
 * major game flow methods that can be used by any such game, and abstract
 * methods that should be implemented by each specific game.
 */
public abstract class SumCardGame extends CardGame implements CardGameMoves, MultiRoundGames {
    private String name;
    private int winCap;
    private int dealerCap;
    private int size;
    private int faceDownIndex;
    public SumCardGame(CardGameTable table) {
        super(table);
        if (this instanceof BlackJackGame) {
            name = BlackJackGame.name;
            winCap = BlackJackRules.PLAYER_CAP;
            dealerCap = BlackJackRules.DEALER_CAP;
            size = BlackJackRules.NATURAL_SIZE;
            faceDownIndex = BlackJackRules.FACE_DOWN_CARD_INDEX;
        } else if (this instanceof TriantaEnaGame) {
            name = TriantaEnaGame.name;
            winCap = TriantaEnaRules.PLAYER_CAP;
            dealerCap = TriantaEnaRules.DEALER_CAP;
            size = TriantaEnaRules.NATURAL_SIZE;
            faceDownIndex = TriantaEnaRules.FACE_DOWN_CARD_INDEX;
        }
    }

    public abstract boolean playerMove(Player player, PlayerHand hand);

    /**
     * Game flow methods
     */

    public void dealerMove() {
        // Check if dealer moves are necessary
        Dealer dealer = getTable().getPlayers().getDealer();
        boolean active = false;
        for (Player player : getTable().getPlayers().getPlayers()) {
            for (Hand hand : player.getHands()) {
                if (!hand.getStatus()) {
                    if (!isBust(hand)) {
                        active = true;
                        break;
                    }
                }
            }
            if (active) {
                break;
            }
        }

        if (active) {
            System.out.println("DEALER: Please flip your face down card by press enter");
            Input.pressEnter();
            ArrayList<Card> cards = dealer.getHand().getCards();
            cards.get(faceDownIndex).flipCard(true);
            System.out.println(dealer.getHand());
            // Dealer move
            while (dealer.getHand().getTotalValue() < dealerCap) {
                System.out.println("DEALER: Please hit by press enter");
                Input.pressEnter();
                hit(dealer.getHand());
                System.out.println(dealer.getHand());
            }
        }
    }
    
    @Override
    public boolean playRound() {
        boolean active = false;
        for (Player player : getTable().getPlayers().getPlayers()) {
            boolean update = false;
            ArrayList<PlayerHand> hands = player.getHands();
            for (int i = 0; i < hands.size(); i++) {
                PlayerHand hand = hands.get(i);
                if (hand.getStatus()) {
                    update = true;
                    active = true;
                    if (!playerMove(player, hand)) {
                        break;
                    }
                }
            }
            // Print out resulting hand and update status
            if (update) {
                updateHandsStatus(player);
            }
        }
        return active;
    }
    
    
    public void updateHandsStatus(Player player) {
        for (PlayerHand hand : player.getHands()) {
            if (hand.getStatus()) {
                if (isBust(hand)) {
                    System.out.println("Current hand is bust");
                    hand.setStatus(false);
                }
                if (isWin(hand)) {
                    System.out.println("You have hit " + name);
                    hand.setStatus(false);
                }
            }
            
            System.out.println(player.getName() + ":");
            System.out.println(hand);
        }
    }

      /**
     * Check the winners of the current table, and give/take money when appropriate
     */
    @Override
    public void checkWinner() {
        Players players = getTable().getPlayers();
        Dealer dealer = players.getDealer();
        int dealerValue = players.getDealer().getHand().getTotalValue();
        if (isNatural(dealer.getHand())) {
            for (Player player : players.getPlayers()) {
                for (PlayerHand hand : player.getHands()) {
                    if (isNatural(hand))
                        tie(player, dealer, hand);
                    else 
                        lose(player, dealer, hand);
                }
            }
        } else {
            for (Player player : players.getPlayers()) {
                for (PlayerHand hand : player.getHands()) {
                    // Player loses when bust, regardless of dealer's hand
                    if (isBust(hand)) {
                        System.out.println(player.getName() + "'s hand is bust");
                        lose(player, dealer, hand);
                    } else {
                        // If dealer busts, player win
                        if (isBust(dealer.getHand())) {
                            System.out.println(dealer.getName() + "is bust");
                            win(player, dealer, hand);
                        } else {
                            // Neither player/dealer bust

                            // Compare value
                            if (hand.getTotalValue() > dealerValue) 
                                win(player, dealer, hand);
                            else if (hand.getTotalValue() < dealerValue) 
                                lose(player, dealer, hand);
                            else
                                // Tie
                                if (isNatural(hand))
                                    win(player, dealer, hand);
                                else
                                    tie(player, dealer, hand);
                        }
                    }
                }
            }
        }
    }

    /**
     * A general game flow for games that aims to reach a certain sum such as 
     * Trianta Ena and BlackJack
     */
    public boolean play() {
        startRound();
        boolean active = true;
        while (active) {
            active = playRound();
            Input.pressEnter();
        }

        // Dealer move
        dealerMove();

        // Check winner of and end current round
        checkWinner();
        System.out.println(getTable().getPlayers());
        Input.pressEnter();

        System.out.println("Play another round?");
        return Input.yesOrNo();
    }

    /**
     * Game functions
     */

    @Override
    public void hit(Hand hand) {
        Card card = getTable().getNextCard();
        card.flipCard(true);
        hand.addCard(card);
    }

    @Override
    public void stand(Hand hand) {
        hand.setStatus(false);
    }

    @Override
    public boolean isWin(Hand hand) {
        return hand.getTotalValue() == winCap;
    }
    
    @Override
    public boolean isBust(Hand hand) {
        return hand.getTotalValue() > winCap;
    }

    @Override
    public boolean isNatural(Hand hand) {
        boolean natural = false;
        if (isWin(hand)) {
            ArrayList<Card> cards = hand.getCards();
            if (cards.size() == size) {
                for (Card card : cards) {
                    if (card.getType().equals("A")) {
                        natural = true;
                        break;
                    }
                }
            }
        }
        return natural;
    }

    public void distribute(Player player, Dealer dealer, int money) {
        player.setMoneyWon(player.getMoneyWon() + money);
        dealer.setMoneyWon(dealer.getMoneyWon() - money);
        if (this instanceof TriantaEnaGame) {
            player.setBalance(player.getBalance() + player.getMoneyWon());
            dealer.setBalance(dealer.getBalance() + dealer.getMoneyWon());
        }
    }
}
