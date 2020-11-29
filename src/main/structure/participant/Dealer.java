package structure.participant;

public class Dealer extends Participant {
    private DealerHand hand;
    public Dealer(String name) {
        super(name);
        this.hand = new DealerHand();
    }

    public DealerHand getHand() {
        return hand;
    }
}
