package structure.participant;

public class DealerManager extends Manager {
    private Hand hand;
    public DealerManager(int balance) {
        super(balance);
    }

    public Hand getHand() {
        return hand;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
}
