package structure.participant;

import structure.cards.Card;

public class PlayerHand extends Hand implements CardGamePlayer {
    
    private int bet;

    public PlayerHand(int bet) {
        this.bet = bet;
    }

    @Override
    public void setBet(int bet) {
        this.bet = bet;
    }

    @Override
    public int getBet() {
        return bet;
    }

    @Override
    public String toString() {
        String str = "Bet: " + getBet();
        for (Card card : getCards()) {
            str += card.toString();
            str += "\n";
        }
        return str;
    }
}
