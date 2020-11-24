package games;

import structure.cards.Card;
import structure.participant.*;
import structure.table.CardGameTable;

public abstract class CardGame {
    private CardGameTable table;
    public CardGame(CardGameTable table) {
        this.table = table;
    }

    public abstract void checkWinner();

    public CardGameTable getTable() {
        return table;
    }
}
