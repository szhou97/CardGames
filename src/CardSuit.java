public class CardSuit {
    private String suit;
    public CardSuit(int suit) {
        switch(suit) {
            case 0:
                this.suit = "clubs";
                break;
            case 1:
                this.suit = "diamonds";
                break;
            case 2:
                this.suit = "hearts";
                break;
            case 3:
                this.suit = "spades";
                break;
        }
    }

    public String getSuit() {
        return this.suit;
    }
}
