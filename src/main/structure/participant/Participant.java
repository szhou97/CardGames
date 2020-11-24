package structure.participant;

public abstract class Participant {
    private int gamePlayed;
    private boolean human;
    private int index;
    private int balance;
    public Participant(int index, int human, int balance) {
        this.gamePlayed = 0;
        this.balance = balance;
        if (human == 0)
            this.human = true;
        else 
            this.human = false;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPlayerIndex() {
        return this.index;
    }

    public int getGamesPlayed() {
        return this.gamePlayed;
    }

    public int getBalance() {
        return this.balance;
    }
   
    public void incrementGamePlayed() {
        this.gamePlayed++;
    }

    public boolean isHuman() {
        return this.human;
    }
}
