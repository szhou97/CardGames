import java.util.ArrayList;
import java.util.Random;

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

    public void printDeck() {
        this.cards.forEach((n) -> n.printCard());
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

    

}
