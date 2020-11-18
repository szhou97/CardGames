package participant;

public class Dealer extends Participant {
    private Hand hand;
    public Dealer(int index, int human, int balance) {
        super(index, human, balance);
        this.hand = new Hand(0);
    }

    public void printCards() {
        this.hand.printCards();
    }
}
