package games;

import structure.participant.Players;
import structure.table.CardGameTable;

public abstract class CardGame {
    private CardGameTable table;
    public CardGame(CardGameTable table) {
        this.table = table;
    }

    public abstract boolean play();
    public abstract void checkWinner(Players players);

    public CardGameTable getTable() {
        return table;
    }
}
