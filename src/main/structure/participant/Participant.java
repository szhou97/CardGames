/******************************************************************************
 * Class: Participant
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/
package structure.participant;

/**
 * The participant object holds information on a participant of the current game.
 */
public abstract class Participant implements Comparable<Participant> {
    private final String name;
    private int moneyWon;
    private int balance;
    public Participant(String name)  {
        this.name = name;
        balance = 0;
        moneyWon = 0;
    }

    /**
     * Setters
     */

    public void setMoneyWon(int moneyWon) {
        this.moneyWon = moneyWon;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Getters
     */

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

    /**
     * Compare by balance, useful for sorting
     */
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
