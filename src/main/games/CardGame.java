package games;

import structure.participant.Players;
import structure.table.CardGameTable;

public abstract class CardGame {
    private CardGameTable table;
    public CardGame(CardGameTable table) {
        this.table = table;
    }

    public abstract boolean play();
    public abstract void dealerMove();
    public abstract void checkWinner();

    public CardGameTable getTable() {
        return table;
    }
}
