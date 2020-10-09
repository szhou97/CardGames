public class GameTable {
    
    private Player player1;
    private Player player2;
    private Deck deck;

    public GameTable() {
        this.player1 = new Player(new PlayerType("dealer"));
        this.player2 = new Player(new PlayerType("player"));
        this.deck = new Deck();
    }
}
