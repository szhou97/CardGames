package games.trianta;

import games.Play;
import games.Replayable;
import structure.participant.Players;
import structure.table.CardGameTable;
import utilities.Input;

public class PlayTriantaEna extends Play implements Replayable {
    public PlayTriantaEna(int numPlayers) {
        super(numPlayers);
    }

    public void start() {
        Players players = initPlayers();
        CardGameTable table = new CardGameTable(players, TriantaEnaRules.NUM_DECKS);
        System.out.println("Current players on the table: ");
        System.out.println(table.getPlayers());
        System.out.println("The game will begin now. Good Luck!!");
        Input.pressEnter();
        TriantaEnaGame game = new TriantaEnaGame(table);
        boolean play = true;
        while(play) {
            game.play();
        }
        
    }

    @Override
    public Players initPlayers() {
        Players players = new Players();
        int balance = 0;
        System.out.println("Please enter the balance for players");
        balance = Input.integerInput(100, 10000);
        for (int i = 0; i < getNumPlayers(); i++) {
            players.addPlayer(createPlayer(i + 1, balance));
        }
        players.addDealer(createDealer(balance * 3));
        return players;
    }
}
