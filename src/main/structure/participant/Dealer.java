package structure.participant;

public class Dealer extends Participant {
    private DealerHand hand;
    private int balance;
    public Dealer(String name, boolean human, int balance, int moneyWon) {
        super(name, human, balance, moneyWon);
        this.hand = new DealerHand();
        this.balance = balance;
    }

    public DealerHand getHand() {
        return hand;
    }

    public String toString() {
        return getName() + "\t\t" + getMoneyWon() + "\n";
    }
}
