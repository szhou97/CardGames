/**
 * The Account class stores participants information such as balance, bet,
 * money gain/loss, 
 */
public class Account {
    private int balance;        // The current balance
    private int bet;            // The current bet
    private int initBalance;    // The initial balance
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
     * Set the initial balance
     */
    public void setInitBalance(int b) {
        this.initBalance = b;
    }
    
    /**
     * Calculate the gain/loss for a current round
     * @return the money difference between initial balance and current balance
     */
    
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
    public void setBet(int bet) {
        this.bet = bet;
    }

    /**
     * @return the current bet
     */
    public int getBet() {
        return this.bet;
    }
}
