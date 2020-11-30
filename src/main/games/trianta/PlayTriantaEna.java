/******************************************************************************
 * Class: PlayTriantaEna
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/
package games.trianta;

import java.util.ArrayList;
import java.util.Collections;

import games.Play;
import structure.participant.*;
import structure.table.CardGameTable;
import utilities.*;

/**
 * This class plays the game of trianta ena repeatedly, and checks player information
 */
public class PlayTriantaEna extends Play {
    public PlayTriantaEna(int numPlayers) {
        super(numPlayers);
    }

    public void start() {
        Players players = initPlayers();
        CardGameTable table = new CardGameTable(players, TriantaEnaRules.NUM_DECKS);
        System.out.println("Current players on the table: ");
        System.out.println(table.getPlayers().toString(true));
        System.out.println("\nIn this game, players will start with the same amount of money, while the dealer will start with three times of that amount. ");
        System.out.println("\nThe game will begin now. Good Luck!!");
        Input.pressEnter();
        TriantaEnaGame game = new TriantaEnaGame(table);
        boolean play = true;
        
        while(play) {
            play = game.play();
            System.out.println("Players/Dealer with <=0 balance are removed");
            refreshPlayers(players);
            if (play) {
                if (players.getPlayers().size() != 0) {
                    rotateDealer(players);
                } else {
                    System.out.println("No player left, exiting...");
                    play = false;
                }
            }
            
        }
    }

    @Override
    public Players initPlayers() {
        Players players = new Players();
        System.out.println("Please enter the starting balance for players");
        int balance = Input.integerInput(50, 10000);
        for (int i = 0; i < getNumPlayers(); i++) {
            boolean done = false;
            while(!done) {
                Player player = createPlayer(i + 1);
                System.out.println("Player details: ");
                System.out.println("name: " + player.getName());
                System.out.println("Confirm?");
                if (Input.yesOrNo()) {
                    player.setBalance(balance);
                    players.addPlayer(player);
                    done = true;
                } 
            }
        }
        Dealer dealer = null;
        boolean done = false;
        while (!done) {
            if (PlayerInit.dealerInfo()) {
                dealer = createDealer();
                System.out.println("Dealer details: ");
                System.out.println("name: " + dealer.getName());
                System.out.println("Confirm?");
                if (Input.yesOrNo()) {
                    done = true;
                }
            } else {
                dealer = new Dealer("dealer");
                done = true;
            }
            dealer.setBalance(3*balance);
            players.addDealer(dealer);
        }
        return players;
    }

    @Override
    public void refreshPlayers(Players players) {
        ArrayList<Player> currPlayers = players.getPlayers();
        ArrayList<Player> availablePlayers = new ArrayList<Player>();
        for (Player player : currPlayers) {
            player.setBalance(player.getBalance() + player.getMoneyWon());
            player.setMoneyWon(0);
            if (player.getBalance() > 0) {
                availablePlayers.add(player);
            }
        }
        Dealer dealer = players.getDealer();
        dealer.setBalance(dealer.getBalance() + dealer.getMoneyWon());
        dealer.setMoneyWon(0);
        System.out.println(players.toString(true));
        // Remove dealer if out of money
        if (players.getDealer().getBalance() <= 0) {
            players.addDealer(null);
        } 

        players.setPlayers(availablePlayers);
    }

    private void rotateDealer(Players players) {
        ArrayList<Player> currPlayers = players.getPlayers();
        Dealer dealer = players.getDealer();
        
        Collections.sort(currPlayers);
        if (dealer == null) {
            System.out.println("Dealer has ran out of money, player with most money will become dealer now");
            players.addDealer(makeDealer(currPlayers.get(0)));
        } else {
            Player newDealer = null;
            for (Player player : currPlayers) {
                if (player.getBalance() > dealer.getBalance()) {
                    System.out.println(player.getName() + ": Do you want to be the dealer?");
                    if (Input.yesOrNo()) {
                        newDealer = player;
                        break;
                    }
                }
            }
            if (newDealer != null) {
                players.addPlayer(makePlayer(dealer));
                players.addDealer(makeDealer(newDealer));
                players.remove(newDealer);
            }
        }
    }

    private Dealer makeDealer(Player player) {
        Dealer dealer = new Dealer(player.getName());
        dealer.setBalance(player.getBalance());
        return dealer;
    }

    private Player makePlayer(Dealer dealer) {
        Player player = new Player(dealer.getName());
        player.setBalance(dealer.getBalance());
        return player;
    }
}
