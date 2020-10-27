public class Moves {
    private BlackJackTable bt;
    public Moves(BlackJackTable bt) {
        this.bt = bt;
    }
    public void playerMove(Player player, Hand hand, int selection) {
        switch(selection) {
            case 1:
                System.out.println("Player " + player.getPlayerIndex() 
                                    + " chooses to hit");
                this.hit(hand);
                break;
            case 2:
                System.out.println("Player " + player.getPlayerIndex() 
                                    + " chooses to stand");
                this.stand(hand);
                break;
            case 3:
                System.out.println("Player " + player.getPlayerIndex() 
                                    + " chooses to double up");
                this.doubleUp(hand);
                break;
            case 4:
                System.out.println("Player " + player.getPlayerIndex() 
                                    + " chooses to split");
                this.split(player, hand);
                break;
        }
    }

    /**
     * Player takes another card
     */
    public void hit( Hand hand) {
        Card card = bt.getNextCard();
        card.flipCard(true);
        hand.addCard(card);
    }

    /**
     * Player stop taking cards
     */
    public void stand(Hand hand) {
        hand.setStatus(false);
    }

    /**
     * Player doubles bet, then hit and stand
     */
    public void doubleUp(Hand hand) {
        hand.setBet(hand.getBet() * 2);
        Card card = bt.getNextCard();
        card.flipCard(true);
        hand.addCard(card);
        hand.setStatus(false);
    }

    /**
     * Player splits into two hands. The two hands will move independently
     */
    public void split(Player player, Hand hand) {
        player.split(hand);
    }

    /**
     * Deals a card for a given player
     * @param player
     * @param faceUp
     */
    public void dealCards(Player player, boolean faceUp) {
        for (Hand hand : player.getHands()) {
            Card card = bt.getNextCard();
            card.flipCard(faceUp);
            hand.addCard(card);
        }
    }
    
}
