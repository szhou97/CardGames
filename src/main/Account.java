import java.util.ArrayList;

/**
 * The Account class stores participants information such as balance, bet, money
 * gain/loss,
 */
public class Account {
    private int balance;        // The current balance
    private int bet;            // The current bet
    private int total;          // The total gain/loss
    /**
     * Initializing the account object, 
     */
    public Account() {
        this.total = 0;
    }
    
    /**
     * @return the total value
     */
    public int getTotal() {
        return this.total;
    }

    public void modifyTotal(int num) {
        this.total += num;
    }

    /**
     * Set the current balance
     * @param balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * @return the current balance
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * Set the current bet
     */
    public void setBet(ArrayList<Hand> hands) {
        this.bet = 0;
        for (Hand hand : hands) {
            this.bet += hand.getBet();
        }
    }

    /**
     * @return the current bet
     */
    public int getBet() {
        return this.bet;
    }
}
