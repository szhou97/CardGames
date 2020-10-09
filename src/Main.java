public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck.deckSize());
        for (int i = 0; i < 5; i++) {
            System.out.println(deck.getNextCard().getValue());
        }
        System.out.println(deck.deckSize());
    }
}
