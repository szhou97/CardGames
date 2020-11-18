package participant;

/**
 * The player object contains a PlayerType object, an Account object and 
 * 1-2 Hand object depending on player moves during the game. It serves 
 * the purpose of storing/updating any information related to a single 
 * player
 */
public class Player extends Participant {

    private int index;
    private Hands hands;

    public Player(int index, int human, int balance, int bet) {
        super(index, human, balance);
        this.index = index;
        this.hands = new Hands();
        this.hands.addHand(bet);
    }
    
    public int getIndex() {
        return this.index;
    }

    public void setBet(int bet, Hand hand) {
        hand.setBet(bet);
    }

    public int getCurrentBet() {
        return this.hands.getBet();
    }

    public void reset() {
        this.hands.clearHands();
    }

    public void printPlayer() {
        this.hands.printCards();
    }
}
