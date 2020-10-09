import java.util.ArrayList;
public abstract class GameTable {
    
    private ArrayList<Player> players;
    private Deck deck;

    public GameTable(int numPlayers) {
        this.deck = new Deck();
        this.deck.printDeck();
        this.players = new ArrayList<Player>();
        this.players.add(new Player(new PlayerType(0), 0));
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player(new PlayerType(1), i));
        }
    }

    abstract int init();

    public void printRecords() {
        System.out.println("Player    " 
                        + "Role      " 
                        + "Games Played     "
                        + "Games Won     " 
                        + "Total balance");
        this.players.forEach((n) ->
            System.out.println(n.getPlayerIndex() + "         "
                        + n.getPlayerType() + "        "
                        + n.getGamesPlayed() + "                "
                        + n.getGamesWOn() + "             "
                        + n.getBalance())
        );
    }



}
