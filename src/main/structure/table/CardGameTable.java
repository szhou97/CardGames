package structure.table;

import java.util.ArrayList;

import structure.cards.*;
import structure.participant.*;

/**
 * The CardGameTable class inherits both GameTable and CardGames, implementing
 * respective methods.
 */
public class CardGameTable extends GameTable implements TableFunctions{

    private Deck deck;
    public CardGameTable(Players players) {
        super(players);
        this.deck = new Deck();
    }

    public void distribute(Participant player, Participant dealer, int amount) {
        // TODO
    }

    /**
     * @return the next card
     */
    public Card getNextCard() {
        return this.deck.getNextCard();
    }

    /**
     * Provide a new deck
     */
    @Override
    public void newDeck() {
        this.deck = new Deck();
    }

    /**
     * @return the deck size
     */
    @Override
    public int deckSize() {
        return this.deck.deckSize();
    }

    @Override
    public void dealCard(Hand hand, Card card) {
        hand.addCard(card);
    }

    public String toString() {
        String str = "Players: \n";
        ArrayList<Player> players = getPlayers().getPlayers();
        Dealer dealer = getPlayers().getDealer();
        for (int i = 0; i < players.size(); i++) {
            str += "\n";
            str += players.get(i).getName() + "\n";
            ArrayList<PlayerHand> hands = players.get(i).getHands();
            for (int j = 0; j < hands.size(); j++) {
                str += "Hand: " + j + "\n";
                str += hands.get(j);
            }
        }
        str += "\nDealer: \n";
        str += dealer.getName() + "\n" + dealer.getHand();
        return str;
    }
}
