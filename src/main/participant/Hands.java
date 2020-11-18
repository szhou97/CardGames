package participant;

import java.util.ArrayList;

import structure.cards.Card;

public class Hands {
    private ArrayList<Hand> hands;
    public Hands() {
        this.hands = new ArrayList<Hand>();
    }

    public void addHand(int bet) {
        this.hands.add(new Hand(bet));
    }

    public int getBet() {
        int bet = 0;
        for (Hand hand : hands) {
            bet += hand.getBet();
        }
        return bet;
    }

    public boolean getStatus() {
        boolean active = false;
        for (Hand hand : hands) {
            if (hand.getStatus()) {
                active = true;
            }
        }
        return active;
    }

    public void clearHands() {
        this.hands = new ArrayList<Hand>();
    }

    public boolean checkDouble() {
        boolean d = false;
        for (int i = 0; i < this.hands.size(); i++) {
            d = this.hands.get(i).checkDouble();
            if (d) { return d; }
        }
        return d;
    }

    public void split(Hand hand) {
        Hand newHand = new Hand(hand.getBet());
        hand.removeLastCard();
        for (Card card : hand.getCards()) {
            newHand.addCard(card);
        }
        newHand.setBet(hand.getBet());
        hands.add(newHand);
    }

    public void printCards() {
        for(int i = 0; i < this.hands.size(); i++) {
            Hand hand = hands.get(i);
            System.out.println("Hand : " + i);
            hand.printCards();
        }
    }
}
