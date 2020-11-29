package structure.cards;

import java.util.ArrayList;
import java.util.Random;

public class Shoe {
    private ArrayList<Card> shoe;
    public Shoe(int numDecks) {
        shoe = new ArrayList<Card>();
        init(numDecks);
    }

    private void init(int numDecks) {
        for (int i = 0; i < numDecks; i++) {
            addDeck();
        }
    }

    public void addDeck() {
        Deck deck = new Deck();
        ArrayList<Card> cards = deck.getCards();
        for (Card card : cards) {
            shoe.add(card);
        }
    }

    /**
     * This method generates a card randomly from the remaining deck
     * @return
     */
    public Card getNextCard() {
        Random r = new Random();
        Card card = shoe.remove(r.nextInt(shoe.size()));
        if (shoe.size() <= 0) {
            addDeck();
        }
        return card;
    }
}
