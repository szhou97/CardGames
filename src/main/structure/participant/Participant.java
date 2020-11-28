package structure.participant;

public abstract class Participant {
    private final String name;
    private int gamePlayed;
    private boolean human;
    private int moneyWon;
    public Participant(String name, boolean human, int moneyWon) {
        this.name = name;
        this.gamePlayed = 0;
        this.human = human;
        this.moneyWon = moneyWon;
    }

    public void setMoneyWon(int moneyWon) {
        this.moneyWon = moneyWon;
    }

    public String getName() {
        return this.name;
    }

    public int getGamesPlayed() {
        return this.gamePlayed;
    }

    public int getMoneyWon() {
        return this.moneyWon;
    }
   
    public void incrementGamePlayed() {
        this.gamePlayed++;
    }

    public boolean isHuman() {
        return this.human;
    }
}
