package structure.participant;

import java.util.ArrayList;

public class PlayerManager extends Manager {
    private ArrayList<PlayerHand> hands;
    public PlayerManager(int balance) {
        super(balance);
        hands = new ArrayList<PlayerHand>();
    }
    public ArrayList<PlayerHand> getHands() {
        return hands;
    }

    public int getTotalBet() {
        int bet = 0;
        for (PlayerHand hand : hands) {
            bet += hand.getBet();
        }
        return bet;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
}
