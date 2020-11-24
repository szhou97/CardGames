package structure.table;

import java.util.ArrayList;

import games.CardGames;
import structure.cards.*;
import structure.participant.*;

/**
 * The CardGameTable class inherits both GameTable and CardGames, implementing
 * respective methods.
 */
public class CardGameTable extends GameTable implements CardGames{

    private Deck deck;
    public CardGameTable(Players players) {
        super(players);
        this.deck = new Deck();
    }

    public void distribute(Participant player, Participant dealer, int amount) {
        // TODO
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

    @Override
    public void dealCard(Hand hand, Card card) {
        hand.addCard(card);
    }
}
