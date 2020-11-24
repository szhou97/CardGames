package structure.cards;

import java.util.ArrayList;
import java.util.Random;
/**
 * A deck class that contains a standard deck of 52 cards. 
 */
public class Deck {
    private ArrayList <Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards.add(new Card(new CardType(j + 1), new CardSuit(i), false) );
            }
        }
    }

    public int deckSize() {
        return this.cards.size();
    }

    /**
     * This method generates a card randomly from the remaining deck
     * @return
     */
    public Card getNextCard() {
        Random r = new Random();
        return this.cards.remove(r.nextInt(this.cards.size()));
    }

    public String toString() {
        String out = "";
        for (Card card : cards) {
            out += card.toString();
        }
        return out;
    }

    

}
