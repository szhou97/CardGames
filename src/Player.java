import java.util.ArrayList;
/**
 * The player object contains a PlayerType object, an Account object and 
 * 1-2 Hand object depending on player moves during the game. It serves 
 * the purpose of storing/updating any information related to a single 
 * player
 */
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

    public int getTotal() {
        return this.account.getTotal();
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

    public void winOrLose(int num) {
        int balance = this.account.getBalance();
        this.account.setBalance(balance + num);
        this.account.modifyTotal(num);
    }
    
    public void printCards() {
        for(int i = 0; i < this.hands.size(); i++) {
            Hand hand = hands.get(i);
            System.out.println("Hand : " + i);
            hand.printCards();
        }
    }
    
    public void dealCards(Card card, Hand hand) {
        hand.addCard(card);
    }
    
    public void split() {
        Hand hand = new Hand();
        hand.addCard(this.hands.get(0).getLastCard());
        hands.add(hand);
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
