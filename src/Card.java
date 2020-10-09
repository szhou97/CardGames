package CS611Assignment3.src;

public class Card {

    private String value;
    private CardType type;

    public Card(CardType type) {
        this.type = type;
        this.value = this.type.getType()
    }

    public int getValue() {
        return this.value;
    }
}
