package games;

import java.util.ArrayList;

import structure.participant.Dealer;
import structure.participant.Player;
import structure.participant.Players;
import utilities.Input;
import utilities.PlayerInit;

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

    public Player createPlayer(int index, int balance) {
        boolean done = false;
        Player player = null;
        while(!done) {
            System.out.println("Creating player " + (index + 1));
            String name = PlayerInit.setName();
            int bet = PlayerInit.setBet(balance);
            System.out.println("Player details: ");
            System.out.println("name: " + name + ", bet: " + bet);
            System.out.println("Confirm?");
            if (Input.yesOrNo()) {
                player = new Player(name, true, bet, 0, 0);
                done = true;
            } 
        }
        return player;
    }

    public Dealer createDealer(int balance) {
        boolean done = false;
        Dealer dealer = null;
        while (!done) {
            String name = "dealer";
            boolean human = false;
            if (PlayerInit.dealerInfo()) {
                human = true;
                name = PlayerInit.setName();
                System.out.println("Dealer details: ");
                System.out.println("name: " + name + ", balance: " + balance);
                System.out.println("Confirm?");
                if (Input.yesOrNo()) {
                    done = true;
                }
            } else {
                done = true;
            }
            dealer = new Dealer(name, human, balance, 0);
        }
        return dealer;
    }
}
