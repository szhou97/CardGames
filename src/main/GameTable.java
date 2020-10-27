import java.util.ArrayList;
/**
 * An abstract class that can be used for any game with a dealer and multiple
 * players. Contains method to initialize, update and print player information
 */
public abstract class GameTable {
    
    private Players players;
    private int numPlayers;
    public GameTable(int numPlayers) {
        this.numPlayers = numPlayers;
        this.players = new Players(new ArrayList<Player>());
        Player dealer = new Player(new PlayerType(0), 0);
        this.players.add(dealer);
        for (int i = 1; i <= numPlayers; i++) {
            Player player = new Player(new PlayerType(1), i);
            players.add(player);
        }
    }

    public void addPlayer() {
        Player player = new Player(new PlayerType(1), numPlayers + 1);
        player.incrementGamePlayed();
        this.players.add(player);
        this.numPlayers++;
    }

    public void incrementGamesPlayed() {
        for (Player player : this.players.getPlayers()) {
            player.incrementGamePlayed();
        }
    }

    public Players getPlayers() {
        return this.players;
    }

    public void printRecords() {
        Printer.printRecord(this.players.getPlayers());
    }

    public void printTable() {
        Printer.printTable(this.players.getPlayers());
    }
}
