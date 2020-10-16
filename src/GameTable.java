import java.util.ArrayList;
public abstract class GameTable {
    
    private Printer printer;
    private Players players;

    public GameTable(int numPlayers) {
        this.printer = new Printer();
        this.players = new Players(new ArrayList<Player>());
        this.players.add(new Player(new PlayerType(0), 0));
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player(new PlayerType(1), i));
        }
        
    }

    public Players getPlayers() {
        return this.players;
    }

    public void printRecords() {
        this.printer.printRecord(this.players.getPlayers());
    }

    public void printTable() {
        this.printer.printTable(this.players.getPlayers());
    }
}
