package structure.participant;

public abstract class Manager {

    private int balance;
    public Manager(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public abstract String toString();
}
