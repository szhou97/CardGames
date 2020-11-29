/******************************************************************************
 * Class: CardGameTable
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/
package structure.table;

import java.util.ArrayList;

import structure.cards.*;
import structure.participant.*;

/**
 * The CardGameTable class inherits both GameTable and TableFunctions, implementing
 * respective methods. It is used primarily for accessing players and getting cards
 */
public class CardGameTable extends GameTable implements TableFunctions{

    private Shoe shoe;
    public CardGameTable(Players players, int numDecks) {
        super(players);
        shoe = new Shoe(numDecks);
    }

    /**
     * @return the next card
     */
    public Card getNextCard() {
        return shoe.getNextCard();
    }
    
    /**
     * Deal a card to a specific hand
     */
    @Override
    public void dealCard(Hand hand, Card card) {
        hand.addCard(card);
    }

    public String toString() {
        String str = "Players: \n";
        ArrayList<Player> players = getPlayers().getPlayers();
        Dealer dealer = getPlayers().getDealer();
        for (int i = 0; i < players.size(); i++) {
            str += "\n";
            str += players.get(i).getName() + "\n";
            ArrayList<PlayerHand> hands = players.get(i).getHands();
            if (hands.size() != 0) {
                for (int j = 0; j < hands.size(); j++) {
                    str += "Hand: " + j + "\n";
                    str += hands.get(j);
                }
            }
        }
        str += "\nDealer: \n";
        str += dealer.getName() + "\n" + dealer.getHand();
        return str;
    }

    
}
