package games;

import structure.cards.Card;
import structure.participant.*;
import structure.table.CardGameTable;

public abstract class SumCardGame extends CardGame implements CardGameMoves {
    public SumCardGame(CardGameTable table) {
        super(table);
    }

    @Override
    public void hit(Hand hand) {
        Card card = getTable().getNextCard();
        card.flipCard(true);
        hand.addCard(card);
    }

    @Override
    public void stand(Hand hand) {
        hand.setStatus(false);
    }

    public boolean isBust(Hand hand, int maxValue) {
        boolean result = false;
        if (hand.getTotalValue() > maxValue) {
            result = true;
        }

        return result;
    }

    public void distribute(Player player, Dealer dealer, int money) {
        player.setMoneyWon(player.getMoneyWon() + money);
        dealer.setMoneyWon(dealer.getMoneyWon() - money);
    }
}
