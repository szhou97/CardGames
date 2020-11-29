/******************************************************************************
 * Class: TableFunctions
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/
package structure.table;

import structure.cards.Card;
import structure.participant.Hand;

/**
 * An interface providing methods that need to be implemented by all card games
 */
public interface TableFunctions {
    public Card getNextCard();  // Returns a new card from the shoe
    public void dealCard(Hand hand, Card card);
}
