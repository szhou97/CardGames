/******************************************************************************
 * Class: Replayable
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/
package games;

import structure.participant.Players;
/**
 * Methods that should be implemented by replayable games
 */
public interface Replayable {
    public Players initPlayers();
    public void refreshPlayers(Players players);
}
