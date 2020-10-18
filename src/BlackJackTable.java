/**
 * The BlackJackTable class inherits both GameTable and CardGames, implementing
 * respective methods.
 */
public class BlackJackTable extends GameTable implements CardGames{

    private Deck deck;
    public BlackJackTable(int numPlayers) {
        super(numPlayers);
        this.deck = new Deck();
    }

    /**
     * @return the next card
     */
    public Card getNextCard() {
        return this.deck.getNextCard();
    }

    /**
     * Provide a new deck
     */
    @Override
    public void newDeck() {
        this.deck = new Deck();
    }

    /**
     * @return the deck size
     */
    @Override
    public int deckSize() {
        return this.deck.deckSize();
    }
}
