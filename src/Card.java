public class Card {
    private String value;
    private CardType type;
    public Card(CardType type) {
        this.type = type;
        this.value = this.type.getType();
    }

    public String getValue() {
        return this.value;
    }
}
