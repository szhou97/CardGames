public class Card {
    private CardType type;
    private CardSuit suit;
    private boolean faceUp;
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
    
    public void flipCard() {
        this.faceUp = true;
    }
    
    public void printCard() {
        String out = "";
        if (this.faceUp) {
            out = this.type.getType() + " of " + this.suit.getSuit();
        } else {
            out = "***";
        }
        System.out.println(out);
    }
}
