package games;

import structure.cards.Card;
import structure.participant.Hand;

/**
 * An interface providing methods that need to be implemented by all card games
 */
public interface CardGames {
    public Card getNextCard();  // Returns a new card from the shoe
    public void newDeck();      // Creates a new deck of cards
    public int deckSize();      // Returns the size of the current deck
    public void dealCard(Hand hand, Card card);
}
