public class Account {
    private int balance;
    private int bet;
    private int initBalance;
    private int total;

    public Account() {
        this.total = 0;
    }

    public void setTotal() {
        this.total += this.monDiff();
    }

    public int getTotal() {
        return this.total;
    }

    public void setInitBalance(int b) {
        this.initBalance = b;
    }

    public int monDiff() {
        return this.balance - this.initBalance;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getBet() {
        return this.bet;
    }

    public void updateAccount(boolean win){
        if (win) {
            this.balance += this.bet;
        } else {
            this.balance -= this.bet;
        }

        this.bet = 0;
    }
}
