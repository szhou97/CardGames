public class Card {
    private CardType type;
    private CardSuit suit;
    public Card(CardType type, CardSuit suit) {
        this.type = type;
        this.suit = suit;
    }

    public String getValue() {
        return null;
    }

    public String getCard() {
        String str = this.type.getType() + " of " + this.suit.getSuit();
        return str;
    }
}
