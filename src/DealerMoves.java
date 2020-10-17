import java.util.ArrayList;

public class DealerMoves {
    private BlackJackTable bt;
    private ArrayList<Player> currPlayers;
    private Player dealer;
    private inputPrompt in;
    private int count;
    private Hand hand;
    public DealerMoves(Player dealer, 
                ArrayList<Player> currPlayers, 
                BlackJackTable bt) 
    {
        this.bt = bt;
        this.dealer = dealer;
        this.in = new inputPrompt();
        this.count = 0;
        this.currPlayers = currPlayers;
        this.hand = dealer.getHands().get(0);
    }

    public void reset() {
        this.count = 0;
    }
    
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

    public void hit() {
        Card card = bt.getNextCard();
        card.flipCard(true);
        dealer.dealCards(card, hand);
    }
}
