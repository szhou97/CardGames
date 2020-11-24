package structure.participant;

import structure.cards.Card;

public class DealerHand extends Hand implements CardGameDealer {
    public DealerHand() {

    }

    @Override
    public void flipCard(Card card) {
        card.flipCard(true);
    }
}
