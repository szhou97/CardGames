package structure.participant;

public abstract class Participant implements Comparable<Participant> {
    private final String name;
    private int moneyWon;
    private int balance;
    public Participant(String name)  {
        this.name = name;
        balance = 0;
        moneyWon = 0;
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

    public String toString() {
        return getName() + "\t\t\t" + getMoneyWon();
    }

    public int compareTo(Participant p) {
        int result = 0;
        if (getBalance() < p.getBalance()) {
            result = 1;
        } else if (getBalance() == p.getBalance()) {
            result = 0;
        } else {
            result = -1;
        }
        return result;
    }
}
