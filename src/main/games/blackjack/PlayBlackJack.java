package games.blackjack;

import java.util.ArrayList;

import structure.participant.*;
import structure.table.CardGameTable;
import utilities.Input;
import utilities.PlayerInit;


public class PlayBlackJack {
    private int numPlayers;
    public PlayBlackJack(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public boolean start() {
        Players players = initPlayers();
        CardGameTable table = new CardGameTable(players);
        System.out.println("Current players on the table: ");
        System.out.println(table.getPlayers());
        System.out.println("The game will begin now. Good Luck!!");
        Input.pressEnter();
        BlackJackGame game = new BlackJackGame(table);
        boolean play = true;
        while(play) {
            play = game.play();
            if (play) {
                refreshPlayers(players);
            }
        }
        return false;
    }

    private void refreshPlayers(Players players) {
        Dealer dealer = players.getDealer();
        ArrayList<Player> p = players.getPlayers();
        dealer.getHand().clearHand();
        for (Player player : p) {
            System.out.println(player.getName() + ":");
            int bet = PlayerInit.setBet(10000);
            player.placeNewBet(bet);
            player.setMoneyWon(player.getMoneyWon() - bet);
        }
    }

    private Players initPlayers() {
        Players players = new Players();
        int minDealerBalance = 0;
        for (int i = 0; i < numPlayers; i++) {
            boolean done = false;
            while(!done) {
                System.out.println("Creating player " + (i + 1));
                String name = PlayerInit.setName();
                int bet = PlayerInit.setBet(10000);
                minDealerBalance += bet;
                System.out.println("Player details: ");
                System.out.println("name: " + name + ", bet: " + bet);
                System.out.println("Confirm?");
                if (Input.yesOrNo()) {
                    Player player = new Player(name, true, bet, 0);
                    players.addPlayer(player);
                    done = true;
                } 
            }
        }
        boolean done = false;
        while (!done) {
            String name = "dealer";
            boolean human = false;
            int balance = 10000000;
            if (PlayerInit.dealerInfo()) {
                human = true;
                name = PlayerInit.setName();
                System.out.println("The minimum balance for a dealer should be 3 times the total bet of current players");
                balance = PlayerInit.setBalance(minDealerBalance * 3, Integer.MAX_VALUE);
                System.out.println("Dealer details: ");
                System.out.println("name: " + name + ", balance: " + balance);
                System.out.println("Confirm?");
                if (Input.yesOrNo()) {
                    done = true;
                }
            } else {
                done = true;
            }
            Dealer dealer = new Dealer(name, human, balance, 0);
            players.addDealer(dealer);
        }
        return players;
    }
}
