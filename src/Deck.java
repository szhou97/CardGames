import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Deck {
    private ArrayList <Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards.add(new Card(new CardType(j + 1)));
            }
        }
    }

    public void printDeck() {
        this.cards.forEach((n) -> System.out.println(n.getValue()));
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
