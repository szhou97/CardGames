package games;

import structure.cards.Card;
import structure.participant.*;
import structure.table.CardGameTable;

public abstract class SumCardGame extends CardGame {
    public SumCardGame(CardGameTable table) {
        super(table);
    }

    /**
     * Player takes another card
     */
    public void hit(Hand hand) {
        Card card = getTable().getNextCard();
        card.flipCard(true);
        hand.addCard(card);
    }

    /**
     * Player stop taking cards
     */
    public void stand(Hand hand) {
        hand.setStatus(false);
    }

    public boolean isBust(Hand hand, int maxValue) {
        return hand.getTotalValue() > maxValue;
    }
}
