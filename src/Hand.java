import java.util.ArrayList;
/**
 * Represent a hand of a player. A hand object is dedicated to maintain cards
 */
public class Hand {
    private ArrayList<Card> cards;
    private boolean active;
    private boolean bust;
    public Hand() {
        this.cards = new ArrayList<Card>();
        this.active = true;
        this.bust = false;
    }

    public void setBust() {
        this.bust = true;
    }

    public boolean bust() {
        return this.bust;
    }
    public boolean getStatus() {
        return this.active;
    }
    
    public void setStatus(boolean active) {
        this.active = active;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void flipLastCard() {
        this.cards.get(this.cards.size() - 1).flipCard(true);
    }
    
    public Card getLastCard() {
        int index = this.cards.size() - 1;
        return this.cards.remove(index);
    }
    
    public void printCards() {
        this.cards.forEach((n) -> n.printCard());
        System.out.println("Total value :" + this.getTotalValue());
    }

    public boolean checkDouble() {
        if (this.cards.size() >= 2) {
            Card card1 = this.cards.get(this.cards.size() - 1);
            Card card2 = this.cards.get(this.cards.size() - 2);
            return card1.getType().equals(card2.getType());
        } else {
            return false;
        }
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

}
