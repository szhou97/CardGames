/******************************************************************************
 * Class: Play
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/
package games;

import java.util.ArrayList;

import structure.participant.*;
import utilities.PlayerInit;

/**
 * This class contains the methods to manipulate some player information
 */
public abstract class Play implements Replayable {
    private int numPlayers;
    public Play(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public abstract void start();

    public int getNumPlayers() {
        return numPlayers;
    }

    @Override
    public void refreshPlayers(Players players) {
        Dealer dealer = players.getDealer();
        ArrayList<Player> p = players.getPlayers();
        dealer.getHand().clearHand();
        for (Player player : p) {
            System.out.println(player.getName() + ":");
            int bet = PlayerInit.setBet(player.getBalance());
            player.placeNewBet(bet);
        }
    }

    public Player createPlayer(int index) {
        System.out.println("Creating player " + index);
        String name = PlayerInit.setName();
        return new Player(name);
    }

    public Dealer createDealer() {
        System.out.println("Creating dealer ");
        String name = PlayerInit.setName();
        return new Dealer(name);
    }
}
