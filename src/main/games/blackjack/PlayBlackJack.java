package games.blackjack;

import games.Play;
import games.Replayable;
import structure.participant.*;
import structure.table.*;
import utilities.*;


public class PlayBlackJack extends Play implements Replayable {
    public PlayBlackJack(int numPlayers) {
        super(numPlayers);
    }

    public void start() {
        Players players = initPlayers();
        CardGameTable table = new CardGameTable(players, BlackJackRules.NUM_DECKS);
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
    }

    @Override
    public Players initPlayers() {
        Players players = new Players();
        for (int i = 0; i < getNumPlayers(); i++) {
            boolean done = false;
            while(!done) {
                System.out.println("Creating player " + (i + 1));
                String name = PlayerInit.setName();
                int bet = PlayerInit.setBet(100000);
                System.out.println("Player details: ");
                System.out.println("name: " + name + ", bet: " + bet);
                System.out.println("Confirm?");
                if (Input.yesOrNo()) {
                    players.addPlayer(new Player(name, true, bet, 0, 0));
                    done = true;
                } 
            }
        }
        boolean done = false;
        while (!done) {
            String name = "dealer";
            boolean human = false;
            if (PlayerInit.dealerInfo()) {
                human = true;
                name = PlayerInit.setName();
                System.out.println("Dealer details: ");
                System.out.println("name: " + name);
                System.out.println("Confirm?");
                if (Input.yesOrNo()) {
                    done = true;
                }
            } else {
                done = true;
            }
            players.addDealer(new Dealer(name, human, 0, 0));
        }
        return players;
    }
}
