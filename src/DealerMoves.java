import java.util.ArrayList;
/**
 * A class dedicated to moves that are made by a dealer. This class will have 
 * access to all the current players on the dealer's table
 */
public class DealerMoves {
    private BlackJackTable bt;
    private ArrayList<Player> currPlayers;
    private Player dealer;
    private inputPrompt in;
    private int count;
    private Hand hand;
    /**
     * Constructor
     */
    public DealerMoves(Player dealer, 
                ArrayList<Player> currPlayers, 
                BlackJackTable bt) {
        this.bt = bt;
        this.dealer = dealer;
        this.in = new inputPrompt();
        this.count = 0;
        this.currPlayers = currPlayers;
        this.hand = dealer.getHands().get(0);
    }

    /**
     * Called when a new round of game starts
     */
    public void reset() {
        this.count = 0;
    }
    
    /**
     * Make a dealer move. When true, dealer can hit. Otherwise, dealer can 
     * only press enter
     * @param move
     */
    public void makeMove(boolean move) {
        System.out.println("DEALER: Please make a move");
        if (!move) {
            System.out.println("Press enter to deal a round of cards");
            in.pressEnterPrompt();
            this.dealCards();
        } else {
            System.out.println("Press enter to HIT");
            in.pressEnterPrompt();
            this.hit();
        }
    }

    /**
     * Deal a round of cards for the current players
     */
    public void dealCards() {
        for (int i = 0; i < this.currPlayers.size(); i++) {
            Player player = this.currPlayers.get(i);
            for (Hand hand : player.getHands()) {
                Card card = bt.getNextCard();
                card.flipCard(true);
                player.dealCards(card, hand);
            }
            
        }
        Card card = bt.getNextCard();
        if (this.count != 1) {
            card.flipCard(true);
        }
        dealer.dealCards(card, hand);
        this.count++;
    }

    /**
     * Dealer hits and obtains a new card
     */
    public void hit() {
        Card card = bt.getNextCard();
        card.flipCard(true);
        dealer.dealCards(card, hand);
    }
}
