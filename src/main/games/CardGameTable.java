package games;

import participant.Participant;
import participant.Players;
import structure.GameTable;
import structure.cards.Card;
import structure.cards.Deck;

/**
 * The BlackJackTable class inherits both GameTable and CardGames, implementing
 * respective methods.
 */
public class CardGameTable extends GameTable implements CardGames{

    private Deck deck;
    public CardGameTable(Players players) {
        super(players);
        this.deck = new Deck();
    }

    public void distribute(Participant player, Participant dealer, int amount) {
        player.updateAccount(amount);
        dealer.updateAccount(-amount);
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
