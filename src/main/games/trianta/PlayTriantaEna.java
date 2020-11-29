package games.trianta;

import games.Play;
import games.Replayable;
import structure.participant.Dealer;
import structure.participant.Player;
import structure.participant.Players;
import structure.table.CardGameTable;
import utilities.Input;
import utilities.PlayerInit;

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
            play = game.play();
            if (play) {
                refreshPlayers(players);
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
                System.out.println("Creating player " + (i + 1));
                String name = PlayerInit.setName();
                System.out.println("Player details: ");
                System.out.println("name: " + name + ", balance: " + balance);
                System.out.println("Confirm?");
                if (Input.yesOrNo()) {
                    players.addPlayer(new Player(name, true, 0, balance, 0));
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
                System.out.println("name: " + name + ", balance: " + 3*balance);
                System.out.println("Confirm?");
                if (Input.yesOrNo()) {
                    done = true;
                }
            } else {
                done = true;
            }
            players.addDealer(new Dealer(name, human, 3*balance, 0));
        }
        return players;
    }

    private void rotateDealer(Players players) {

    }
}
