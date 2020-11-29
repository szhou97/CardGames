package structure.participant;

public abstract class Participant {
    private final String name;
    private boolean human;
    private int moneyWon;
    private int balance;
    public Participant(String name, boolean human, int balance, int moneyWon) {
        this.name = name;
        this.human = human;
        this.moneyWon = moneyWon;
        this.balance = balance;
    }

    public void setMoneyWon(int moneyWon) {
        this.moneyWon = moneyWon;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return balance;
    }

    public int getMoneyWon() {
        return this.moneyWon;
    }

    public boolean isHuman() {
        return this.human;
    }
}
