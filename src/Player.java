import java.util.ArrayList;

public class Player {

    private PlayerType role;
    private Account account;
    private int index;
    private int gamePlayed;
    private int gameWon;
    private Hand hand;
    private ArrayList<Hand> hands;

    public Player(PlayerType role, int playerIndex) {
        this.role = role;
        this.index = playerIndex;
        this.gamePlayed = 0;
        this.gameWon = 0;
        this.account = new Account();
        this.hand = new Hand(1);
        this.hands = new ArrayList<Hand>();
        this.hands.add(this.hand);
    }

    public int getPlayerIndex() {
        return this.index;
    }

    public void setPlayerType(int type) {
        this.role.setPlayerType(type);
    }

    public String getPlayerType() {
        return this.role.getPlayerType();
    }

    public int getGamesPlayed() {
        return this.gamePlayed;
    }
   
    public void incrementGamePlayed() {
        this.gamePlayed++;
    }

    public int getGamesWOn() {
        return this.gameWon;
    }

    public void incrementGameWon() {
        this.gameWon++;
    }

    public void setBet(int bet) {
        this.account.setBet(bet);
    }

    public int getCurrentBet() {
        return this.account.getBet();
    }

    public void modifyBet(int bet) {
        this.account.modifyBet(bet);
    }

    public int getBalance() {
        return this.account.getBalance();
    }

    public void setBalance(int balance) {
        this.account.setBalance(balance);
    }

    public void printCards() {
        this.hands.forEach((n) -> 
            n.printCards());
    }
    
    public void dealCards(Card card) {
        this.hands.forEach((n) -> n.addCard(card));
    }
    
    public void updateResult(boolean win) {
        if (win) gameWon++;
        this.account.updateAccount(win);
    }
}
