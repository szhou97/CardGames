public class BlackJackTable extends GameTable implements CardGames{

    private Deck deck;
    public BlackJackTable(int numPlayers) {
        super(numPlayers);
        this.deck = new Deck();
    }

    @Override
    public void dealCards(Player player, boolean faceUp) {
        Card card = this.deck.getNextCard();
        card.flipCard(faceUp);
        player.dealCards(card);
        this.printTable();
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
