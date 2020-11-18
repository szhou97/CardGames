package participant;

public abstract class Participant {
    private int gamePlayed;
    private Account account;
    private boolean human;
    private int index;
    public Participant(int index, int human, int balance) {
        this.account = new Account();
        this.gamePlayed = 0;
        if (human == 0)
            this.human = true;
        else 
            this.human = false;
    }

    public int getTotal() {
        return this.account.getTotal();
    }

    public boolean humanControl() {
        return this.human;
    }

    public int getPlayerIndex() {
        return this.index;
    }

    public int getGamesPlayed() {
        return this.gamePlayed;
    }
   
    public void incrementGamePlayed() {
        this.gamePlayed++;
    }

    public void setBalance(int balance) {
        this.account.setBalance(balance);
    }

    public int getBalance() {
        return this.account.getBalance();
    }

    public void updateAccount(int num) {
        int balance = this.account.getBalance();
        this.account.setBalance(balance + num);
        this.account.modifyTotal(num);
    }
}
