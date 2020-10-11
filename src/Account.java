public class Account {
    private int balance;
    private int bet;

    public Account() {

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

    public void modifyBet(int bet) {
        this.bet += bet;
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
