import java.util.ArrayList;
import java.util.Random;

public class PlayerMoves {

    private BlackJackTable bt;
    private Player player;
    private inputPrompt in;
    private ArrayList<Hand> hands;

    public PlayerMoves(Player player, BlackJackTable bt) {
        this.bt = bt;
        this.player = player;
        this.in = new inputPrompt();
        this.hands = player.getHands();
    }

    public int prompt(boolean d) {
        int min = 1, max = 1;
        System.out.print("1: Hit");
        if (this.player.getPlayerType().equals("player")) {
            System.out.print(", 2: Stand, 3: Double up");
            max = 3;
            if (d) {
                System.out.println(", 4: Split");
                max = 4;
            } else {
                System.out.println("");
            }
        }
        return this.in.singleIntegerInput(min, max);
    }
  
    public void makeMove(boolean human) {
        int selection = 0;
        if (human) {
            for (int i = 0; i < hands.size(); i++) {
                Hand hand = hands.get(i);
                if (hand.getStatus()) {
                    System.out.println("Player " + this.player.getPlayerIndex() 
                            + " please make a move (hand " + i + ")");
                    boolean d = player.checkDouble();
                    selection = this.prompt(d);
                    this.moves(selection, hand);
                }
            }
        } else {
            for (int i = 0; i < hands.size(); i++) {
                Hand hand = hands.get(i);
                if (hand.getStatus()) {
                    boolean d = player.checkDouble();
                    if (d) {
                        selection = 4;
                    } else {
                        if (hand.getTotalValue() >= 18) {
                            selection = 2;
                        } else if (hand.getTotalValue() >= 10) {
                            selection = 3;
                        } else {
                            selection = 1;
                        }
                    }
                    this.moves(selection, hand);
                }   
            }
        }
        
    }
    public void moves(int selection, Hand hand) {
        switch(selection) {
            case 1:
                System.out.println("Player " + this.player.getPlayerIndex() 
                                    + " chooses to hit");
                this.hit(hand);
                break;
            case 2:
                System.out.println("Player " + this.player.getPlayerIndex() 
                                    + " chooses to stand");
                this.stand(hand);
                break;
            case 3:
                System.out.println("Player " + this.player.getPlayerIndex() 
                                    + " chooses to double up");
                this.doubleUp(hand);
                break;
            case 4:
                System.out.println("Player " + this.player.getPlayerIndex() 
                                    + " chooses to split");
                this.split();
                break;
        }
    }

    public void hit(Hand hand) {
        Card card = bt.getNextCard();
        card.flipCard(true);
        this.player.dealCards(card, hand);
    }

    public void stand(Hand hand) {
        hand.setStatus(false);
    }

    public void doubleUp(Hand hand) {
        int bet = player.getCurrentBet();
        this.player.setBet(2*bet);
        Card card = bt.getNextCard();
        card.flipCard(true);
        this.player.dealCards(card, hand);
        hand.setStatus(false);
    }

    public void split() {
        this.player.split();
        this.makeMove(player.humanControl());
    }

    
}
