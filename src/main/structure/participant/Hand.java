package structure.participant;

import java.util.ArrayList;
import structure.cards.Card;
/**
 * Represent a hand of a player. A hand object is dedicated to maintain cards
 */
public abstract class Hand {
    private ArrayList<Card> cards;
    private boolean active;
    public Hand() {
        this.cards = new ArrayList<Card>();
        this.active = true;
    }

    public void setStatus(boolean active) {
        this.active = active;
    }

    public boolean getStatus() {
        return this.active;
    }
    
    public ArrayList<Card> getCards() {
        return this.cards;
    }
    

    public int getTotalValue() {
        int value = 0;
        boolean a = false;
        for (int i = 0; i < this.cards.size(); i++) {
            Card c = this.cards.get(i);
            value += c.getValue();
            if (c.getType().equals("A")) 
                a = true;
        }

        if (a) {
            if (value + 10 <= 21) 
                value += 10;
        }
        return value;
    }

    /**
     * Hand modifiers
     */

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    /**
     * Checkers
     */

    public boolean isDouble() {
        if (this.cards.size() >= 2) {
            Card card1 = this.cards.get(this.cards.size() - 1);
            Card card2 = this.cards.get(this.cards.size() - 2);
            return card1.getType().equals(card2.getType());
        } else {
            return false;
        }
    }

    public boolean isBust() {
        return this.getTotalValue() > 21;
    }

    public boolean isNaturalBlackJack() {
        boolean a = false;
        boolean ten = false;
        boolean naturalBlack = false;
        if (this.cards.size() == 2) {
            for (Card card : this.cards) {
                if (card.getType().equals("A")) {
                    a = true;
                }
                if (card.getValue() == 10) {
                    ten = true;
                }
            }
        }
        if (a && !ten) {
            naturalBlack = true;
        }
        return naturalBlack && this.getTotalValue() == 21;
    }

    public String toString() {
        String str = "";
        for (Card card : cards) {
            str += card.toString();
            str += "\n";
        }
        return str;
    }
}
