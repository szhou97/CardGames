/******************************************************************************
 * Class: Deck
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/
package structure.cards;

import java.util.ArrayList;
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

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int deckSize() {
        return this.cards.size();
    }

}
