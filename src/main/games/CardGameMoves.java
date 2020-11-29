/******************************************************************************
 * Class: CardGameMoves
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/
package games;

import structure.participant.Hand;
/**
 * Moves that should be performed by card game players
 */
public interface CardGameMoves {
    public void hit(Hand hand);
    public void stand(Hand hand);
    public boolean isBust(Hand hand);
    public boolean isWin(Hand hand);
    public boolean isNatural(Hand hand);
    public void checkWinner();
}
