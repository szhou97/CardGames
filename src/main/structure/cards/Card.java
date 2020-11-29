/******************************************************************************
 * Class: Card
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/
package structure.cards;

/**
 * The card class represents a card object. Information such as card's type
 * card's suit, and face up/down are stored in the class.
 */
public class Card {
    private CardType type;      // Card's type
    private CardSuit suit;      // Card's suit
    private boolean faceUp;     // Card's face up/down
    public Card(CardType type, CardSuit suit, boolean faceUp) {
        this.type = type;
        this.suit = suit;
        this.faceUp = faceUp;
    }

    public String getSuit() {
        return this.suit.getSuit();
    }

    public String getType() {
        return this.type.getType();
    }

    public int getValue() {
        return this.type.getValue();
    }
    
    public void flipCard(boolean up) {
        this.faceUp = up;
    }

    /**
     * Prints out the card in given format
     */
    public String toString() {
        String out = "";
        if (this.faceUp) {
            out = this.type.getType() + " of " + this.suit.getSuit();
        } else {
            out = "***";
        }
        return out;
    }
}
