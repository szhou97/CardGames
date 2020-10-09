package CS611Assignment3.src;

import java.util.ArrayList;

public class Deck {
    private ArrayList <Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; i++) {
                cards.add(new Card(new CardType(j)))
            }
        }
    }

    public void printDeck() {
        this.cards.forEach((n) -> print(n.getValue()))
    }

    

}
