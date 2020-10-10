import java.util.ArrayList;

public class Player {

    private PlayerType role;
    private int index;
    private int gamePlayed;
    private int gameWon;
    private int currentBet;
    private int balance;
    private ArrayList<Card> cards;

    public Player(PlayerType role, int playerIndex) {
        this.role = role;
        this.index = playerIndex;
        this.gamePlayed = 0;
        this.gameWon = 0;
        this.currentBet = 0;
        this.balance = 0;
        this.cards = new ArrayList<Card>();
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
            this.balance += currentBet;
        } else {
            this.balance -= currentBet;
        }
    }

    public int getPlayerIndex() {
        return this.index;
    }

    public int getCurrentBet() {
        return this.currentBet;
    }

    public int getBalance() {
        return this.balance;
    }

    public int getGamesPlayed() {
        return this.gamePlayed;
    }

    public int getGamesWOn() {
        return this.gameWon;
    }

    public void setPlayerType(int type) {
        this.role.setPlayerType(type);
    }

    public String getPlayerType() {
        return this.role.getPlayerType();
    }

    public void addCard(Card card, boolean faceUp) {
        if (faceUp) 
            card.flipCard();
        this.cards.add(card);
    }

    public void printCards() {
        this.cards.forEach((n) -> n.printCard());
    }

    public int getSum() {
        boolean A = false;
        int sum = 0;
        for (int i = 0; i < this.cards.size(); i++) {
            if (this.cards.get(i).getType().equals("A"))
                A = true;
            sum += this.cards.get(i).getValue();
        }
        if (A) {
            if (sum + 10 <= 21) 
                sum = sum + 10;
        } 
        return sum;
    }
}
