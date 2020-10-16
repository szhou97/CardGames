public class BlackJackTable extends GameTable implements CardGames{

    private Deck deck;
    public BlackJackTable(int numPlayers) {
        super(numPlayers);
        this.deck = new Deck();
    }

    public Card getNextCard() {
        return this.deck.getNextCard();
    }

    @Override
    public void newDeck() {
        this.deck = new Deck();
    }

    @Override
    public int deckSize() {
        return this.deck.deckSize();
    }
}
