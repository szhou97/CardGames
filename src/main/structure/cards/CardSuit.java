/******************************************************************************
 * Class: CardSuit
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/
package structure.cards;

/**
 * A class representing the card suit
 */
public class CardSuit {
    private String suit;
    /**
     * Construct the card suit
     * @param suit
     */
    public CardSuit(int suit) {
        switch(suit) {
            case 0:
                this.suit = "clubs♣";
                break;
            case 1:
                this.suit = "diamonds♦";
                break;
            case 2:
                this.suit = "hearts♥";
                break;
            case 3:
                this.suit = "spades♠";
                break;
        }
    }

    public String getSuit() {
        return this.suit;
    }
}
