package games;

import structure.table.CardGameTable;
import structure.participant.*;

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
