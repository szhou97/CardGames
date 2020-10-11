import java.util.ArrayList;
public abstract class GameTable {
    
    private ArrayList<Player> players;
    private Deck deck;

    public GameTable(int numPlayers) {
        this.deck = new Deck();
        this.players = new ArrayList<Player>();
        this.players.add(new Player(new PlayerType(0), 0));
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player(new PlayerType(1), i));
        }
    }

    abstract int init();

    public void newDeck() {
        this.deck = new Deck();
    }

    public int deckSize() {
        return this.deck.deckSize();
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

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

    public void printTable() {
        ArrayList<Player> records = this.getPlayers();
        for (int i = 0; i < records.size(); i++) {
            Player currP = records.get(i);
            System.out.println("Player " 
                            + currP.getPlayerIndex()
                            + " as "
                            + currP.getPlayerType());
            currP.printCards();
            System.out.println("");
        }
    }

    public void dealCard(Player player, boolean faceUp) {
        Card card = deck.getNextCard();
        card.flipCard(faceUp);
        player.dealCards(card);
    }
}
