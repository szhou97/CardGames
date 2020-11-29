package games.trianta;

import java.util.ArrayList;

import games.*;
import structure.cards.*;
import structure.participant.*;
import structure.table.*;
import utilities.*;

public class TriantaEnaGame extends SumCardGame {
    public static String name = 
        TextColors.ANSI_YELLOW 
        + "Trianta Ena" 
        + TextColors.ANSI_RESET;
    public TriantaEnaGame(CardGameTable table) {
        super(table);
    }

    @Override
    public void startRound() {
        Dealer dealer = getTable().getPlayers().getDealer();
        ArrayList<Player> players = getTable().getPlayers().getPlayers();

        // Deal first round of cards and ask for bet input
        for (Player player : players) {
            System.out.println("DEALER: Press enter to deal a card for " + player.getName());
            Input.pressEnter();
            Card card = getTable().getNextCard();
            card.flipCard(true);
            System.out.println(player.getName() + ", your first card is " + card);
            System.out.println("Please remember your card. It will be kept face down");
            System.out.println("Would you like to place a bet? Select no to fold");
            if (Input.yesOrNo()) {
                System.out.println("Please place a bet. The bet needs to be smaller than your balance.");
                int bet = PlayerInit.setBet(player.getBalance());
                player.placeNewBet(bet);
                Hand hand = player.getHands().get(0);
                card.flipCard(false);
                getTable().dealCard(hand, card);
            } else {
                player.placeNewBet(0);
                player.getHands().get(0).setStatus(false);
            }
        }

        // Dealer gets a card
        System.out.println("DEALER: Press enter to deal a card for yourself");
        Input.pressEnter();
        Card card = getTable().getNextCard();
        card.flipCard(true);
        System.out.println(card);
        card.flipCard(false);
        getTable().dealCard(dealer.getHand(), card);
        Input.pressEnter();

        // Deal two more rounds of cards
        for (int i = 0; i < 2; i++) {
            System.out.println("DEALER: Press enter to deal a round of cards");
            Input.pressEnter();
            for (Player player : players) {
                Hand hand = player.getHands().get(0);
                if (hand.getStatus()) {
                    card = getTable().getNextCard();
                    card.flipCard(true);
                    getTable().dealCard(hand, card);
                }
            }
            card = getTable().getNextCard();
            card.flipCard(true);
            getTable().dealCard(dealer.getHand(), card);
            System.out.println(getTable());
        }
    }

    @Override
    public void playerMove(Player player, PlayerHand hand) {
        int max = 2, input = 0;
        System.out.println(player.getName() + ", please choose what to do for current hand");
        System.out.print("0: view cards, 1: hit, 2: stand");
        System.out.print("\n");
        boolean done = false;
        while (!done) {
            done = true;
            input = Input.integerInput(0, max);
            switch(input) {
                case 0: System.out.println(hand); done = false; break;
                case 1: hit(hand); break;
                case 2: stand(hand); break;
            }
        }
    }

    @Override
    public void tie(Player player, Dealer dealer, PlayerHand hand) {
        System.out.println("Cards are tied, dealer wins");
        lose(player, dealer, hand);
    }

    @Override
    public void win(Player player, Dealer dealer, PlayerHand hand) {
        System.out.println(player.getName() + " won " + hand.getBet());
        distribute(player, dealer, hand.getBet());
    }

    @Override
    public void lose(Player player, Dealer dealer, PlayerHand hand) {
        distribute(player, dealer, -hand.getBet());
    }
}
