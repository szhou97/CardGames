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
    public boolean play() {
        int round = 0;
        int input = 0;

        while (round < 2) {
            System.out.println("The dealer will now deal a round of cards for every player on the table");
            for (Player player : players) {
                Card card = blackJackTable.getNextCard();
                card.flipCard(true);
                blackJackTable.dealCard(player.getHands().get(0), card);
                if (isBlackJack(player.getHands().get(0))) {
                    player.getHands().get(0).setStatus(false);
                }
            }
            Card card = blackJackTable.getNextCard();
            if (round < 1) {
                card.flipCard(true);
            } else {
                card.flipCard(false);
            }
            blackJackTable.dealCard(dealer.getHand(), card);
            System.out.println(blackJackTable);
            round++;
            Input.pressEnter();
        }

        // Player make choices every round
        boolean active = true;
        while (active) {
            active = false;
            for (Player player : players) {
                ArrayList<PlayerHand> hands = player.getHands();
                for (int i = 0; i < hands.size(); i++) {
                    PlayerHand hand = hands.get(i);
                    if (hand.getStatus()) {
                        active = true;
                        int max = 3;
                        System.out.println(player.getName() + ", please choose what to do for Hand: " + i);
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
                }

                if (active) {
                    for (PlayerHand hand : hands) {
                        if (isBust(hand, BlackJackRules.PLAYER_CAP) || isBlackJack(hand)) {
                            hand.setStatus(false);
                        }
                        System.out.println(player.getName() + ":");
                        System.out.println(hand);
                    }
                } else {
                    break;
                }
            }
        }

        // Dealer move
        active = false;
        for (Player player : players) {
            for (Hand hand : player.getHands()) {
                if (!isBust(hand, BlackJackRules.PLAYER_CAP)) {
                    active = true;
                    break;
                }
            }
            if (active) {
                break;
            }
        }

        if (active) {
            while (isBust(dealer.getHand(), BlackJackRules.DEALER_CAP)) {
                System.out.println(dealer.getHand());
                System.out.println("DEALER: Please hit");
                Input.pressEnter();
                hit(dealer.getHand());
            }
        }

        checkWinner(getTable().getPlayers());
        System.out.println(getTable().getPlayers());
        Input.pressEnter();
        System.out.println("Play another round?");
        
        return Input.yesOrNo();
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

    private boolean isBlackJack(Hand hand) {
        boolean result = false;
        if (hand.getTotalValue() == BlackJackRules.PLAYER_CAP) {
            System.out.println("You have hit blackjack!");
            result = true;
        }
        return result;
    }

    private boolean isNaturalBlackJack(Hand hand) {
        boolean naturalBlack = false;
        if (isBlackJack(hand)) {
            ArrayList<Card> cards = hand.getCards();
            if (cards.size() == 2) {
                for (Card card : cards) {
                    if (card.getType().equals("A")) {
                        naturalBlack = true;
                        break;
                    }
                }
            }
        }
        return naturalBlack;
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
    public void checkWinner(Players players) {
        Dealer dealer = players.getDealer();
        int dealerValue = players.getDealer().getHand().getTotalValue();

        for (Player player : players.getPlayers()) {
            for (PlayerHand hand : player.getHands()) {
                boolean playerWin = false;
                // Player loses when bust, regardless of dealer's hand
                if (isBust(hand, BlackJackRules.PLAYER_CAP)) {
                    System.out.println(player.getName() + "'s hand is bust");
                    playerWin = false;
                } else {
                    // If dealer busts, player win
                    if (isBust(dealer.getHand(), BlackJackRules.PLAYER_CAP)) {
                        System.out.println(dealer.getName() + "is bust");
                        playerWin = true;
                    } else {
                        // Neither player/dealer bust
                        if (hand.getTotalValue() > dealerValue) {
                            playerWin = true;
                        } else if (hand.getTotalValue() < dealerValue) {
                            playerWin = false;
                        } else {
                            if (isBlackJack(hand)) {
                                if (isNaturalBlackJack(hand) && !isNaturalBlackJack(dealer.getHand())) {
                                    System.out.println(player.getName() + " is natural black");
                                    playerWin = true;
                                } else if (!isNaturalBlackJack(hand) && isNaturalBlackJack(dealer.getHand())) {
                                    System.out.println(dealer.getName() + " is natural blakc");
                                    playerWin = false;
                                } else {
                                    System.out.println("Game is tie, bet is returned");
                                }
                            }
                        }
                    }
                }
                if (playerWin) { 
                    System.out.println(player.getName() + " won " + 2*hand.getBet());
                    distribute(player, dealer, 2*hand.getBet());
                } else {
                    System.out.println(player.getName() + " lost " + hand.getBet());
                    distribute(player, dealer, -hand.getBet());
                }
            }
        }
    }
}
