/******************************************************************************
 * Class: PlayerHand
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/
package structure.participant;

import structure.cards.Card;

/**
 * The playerhand class holds an integer field (bet), which is unique for players
 */
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
        String str = "Bet: " + getBet() + "\n";
        for (Card card : getCards()) {
            str += card.toString();
            str += "\n";
        }
        return str;
    }
}
