import java.util.ArrayList;

public class Hand {
    private int index;
    private ArrayList<Card> cards;
    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    
    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card getLastCard() {
        int index = this.cards.size() - 1;
        return this.cards.remove(index);
    }
    
    public void printCards() {
        System.out.println("Hand : " + this.index);
        this.cards.forEach((n) -> n.printCard());
    }

    public boolean checkDouble() {
        Card card1 = this.cards.get(0);
        for (int i = 1; i < this.cards.size(); i++) {
            if (this.cards.get(i).getValue() == card1.getValue()) {
                return true;
            } else {
                card1 = this.cards.get(i);
            }
        }
        return false;
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
}
