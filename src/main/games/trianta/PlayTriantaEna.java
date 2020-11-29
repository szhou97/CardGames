package games.trianta;

import games.Play;
import structure.participant.Dealer;
import structure.participant.Player;
import structure.participant.Players;
import structure.table.CardGameTable;
import utilities.Input;
import utilities.PlayerInit;

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

    private void rotateDealer(Players players) {

    }
}
