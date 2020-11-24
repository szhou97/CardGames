package structure.participant;

public class Dealer extends Participant {
    private DealerManager manager;
    public Dealer(int index, int human, int balance) {
        super(index, human, balance);
        manager = new DealerManager(balance);
    }

    public String toString() {
        return getPlayerIndex() + "\t\t";
    }
}
