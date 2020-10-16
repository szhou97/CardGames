import java.util.ArrayList;

public class DealerMoves {
    private BlackJackTable bt;
    private ArrayList<Player> currPlayers;
    private Player dealer;
    private inputPrompt in;
    private int count;
    public DealerMoves(Player dealer, 
                ArrayList<Player> currPlayers, 
                BlackJackTable bt) 
    {
        this.bt = bt;
        this.dealer = dealer;
        this.in = new inputPrompt();
        this.count = 0;
        this.currPlayers = currPlayers;
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
            bt.dealCards(player, true);
        }
        if (this.count == 1)
            bt.dealCards(this.dealer, false);
        else 
            bt.dealCards(this.dealer, true);
        
        this.count++;
    }

    public void hit() {
        bt.dealCards(this.dealer, true);
    }
}
