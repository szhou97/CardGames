package structure.participant;

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
    
}
