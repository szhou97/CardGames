package structure.participant;

public class Dealer extends Participant {
    private DealerHand hand;
    private int balance;
    public Dealer(String name, boolean human, int balance, int moneyWon) {
        super(name, human, moneyWon);
        this.hand = new DealerHand();
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public DealerHand getHand() {
        return hand;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String toString() {
        return getName() + "\t\t" + getMoneyWon() + "\n";
    }
}
