package games.blackjack;

import java.util.ArrayList;

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
            players.addPlayer(createPlayer(i + 1, 100000));
        }
        players.addDealer(createDealer(0));
        return players;
    }
}
