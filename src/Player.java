import java.util.ArrayList;

public class Player {

    private int index;
    private PlayerType role;
    private Account account;
    private int gamePlayed;
    private ArrayList<Hand> hands;
    private boolean human;

    public Player(PlayerType role, int playerIndex) {
        this.role = role;
        this.index = playerIndex;
        this.gamePlayed = 0;
        this.hands = new ArrayList<Hand>();
        this.hands.add(new Hand());
        this.account = new Account();
        this.human = false;
    }
   
    public boolean getStatus() {
        boolean active = false;
        for (Hand hand : hands) {
            if (hand.getStatus()) {
                active = true;
            }
        }
        return active;
    }

    public void setInitBalance(int b) {
        this.account.setInitBalance(b);
    }

    public int monDiff() {
        return this.account.monDiff();
    }

    public boolean humanControl() {
        return this.human;
    }

    public void setHumanControl(boolean human) {
        this.human = human;
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

    public void setBet(int bet) {
        this.account.setBet(bet);
    }

    public int getCurrentBet() {
        return this.account.getBet();
    }

    public void setBalance(int balance) {
        this.account.setBalance(balance);
    }

    public int getBalance() {
        return this.account.getBalance();
    }

    public void printCards() {
        this.hands.forEach((n) -> 
            n.printCards());
    }
    
    public void dealCards(Card card, Hand hand) {
        this.hands.forEach((n) -> n.addCard(card));
    }
    
    public void split() {
        Hand hand = new Hand();
        hand.addCard(this.hands.get(0).getLastCard());
    }
   
    public ArrayList<Hand> getHands() {
        return this.hands;
    }

    public void clearHands() {
        this.hands = new ArrayList<Hand>();
        this.hands.add(new Hand());
    }
    
    public boolean checkDouble() {
        boolean d = false;
        for (int i = 0; i < this.hands.size(); i++) {
            d = this.hands.get(i).checkDouble();
            if (d) { return d; }
        }
        return d;
    }
}
