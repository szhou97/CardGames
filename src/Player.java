public class Player {

    private PlayerType role;
    private int gamePlayed;
    private int gameWon;
    private int currentBet;
    private int result;
    
    public Player(PlayerType role) {
        this.role = role;
    }

    public void setBet(int bet) {
        this.currentBet = bet;
    }

    public void incrementGamePlayed() {
        this.gamePlayed++;
    }

    public void incrementGameWon() {
        this.gameWon++;
    }

    public void updateResult(boolean win) {
        if(win) {
            this.gameWon++;
            result += currentBet;
        } else {
            result -= currentBet;
        }
    }

    public int getCurrentBet() {
        return this.currentBet;
    }

    public int getResult() {
        return this.result;
    }

    public int getGamesPlayed() {
        return this.gamePlayed;
    }

    public int getGamesWOn() {
        return this.gameWon;
    }

    public void setPlayerType(String role) {
        this.role.setPlayerType(role);
    }

    public String getPlayerType() {
        return this.role.getPlayerType();
    }
}
