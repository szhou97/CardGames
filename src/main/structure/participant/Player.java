package structure.participant;

import java.util.ArrayList;

/**
 * The player object contains a PlayerType object, an Account object and 1-2
 * Hand object depending on player moves during the game. It serves the purpose
 * of storing/updating any information related to a single player
 */
public class Player extends Participant {
    private ArrayList<PlayerHand> hands;

    public Player(String name, boolean human, int bet, int balance, int moneyWon) {
        super(name, human, balance, moneyWon);
        hands = new ArrayList<PlayerHand>();
        hands.add(new PlayerHand(bet));
    }

    public void placeNewBet(int bet) {
        this.hands = new ArrayList<PlayerHand>();
        hands.add(new PlayerHand(bet));
    }

    public ArrayList<PlayerHand> getHands() {
        return hands;
    }

    public String toString() {
        return getName() + "\t\t" + getMoneyWon() + "\n";
    }
}
