/******************************************************************************
 * Class: CardGames
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/
package games;

import structure.table.CardGameTable;
import structure.participant.*;
/**
 * The CardGame class contains a CardGameTable, and abstract methods necessary
 * for most generic card games
 */
public abstract class CardGame {
    private CardGameTable table;
    public CardGame(CardGameTable table) {
        this.table = table;
    }

    public abstract boolean play();
    public abstract void tie(Player player, Dealer dealer, PlayerHand hand);
    public abstract void win(Player player, Dealer dealer, PlayerHand hand);
    public abstract void lose(Player player, Dealer dealer, PlayerHand hand);
    public abstract void distribute(Player player, Dealer dealer, int money);

    public CardGameTable getTable() {
        return table;
    }
}
