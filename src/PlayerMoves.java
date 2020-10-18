import java.util.ArrayList;
/**
 * The PlayerMoves class contains the moves that can be performed by a player
 * in a black jack game
 */
public class PlayerMoves {

    private BlackJackTable bt;
    private Player player;
    private inputPrompt in;
    private ArrayList<Hand> hands;
    private boolean human;

    public PlayerMoves(Player player, BlackJackTable bt) {
        this.bt = bt;
        this.player = player;
        this.in = new inputPrompt();
        this.hands = player.getHands();
        this.human = false;
    }

    /**
     * Let's user select moves
     */
    public int prompt(boolean d) {
        int min = 1, max = 1;
        System.out.print("1: Hit");
        if (this.player.getPlayerType().equals("player")) {
            System.out.print(", 2: Stand, 3: Double Up");
            max = 3;
            if (d) {
                System.out.print(", 4: Split");
                max = 4;
            } 
            System.out.println("");
            
        }
        return this.in.singleIntegerInput(min, max);
    }
  
    public void makeMove(boolean human) {
        this.human = human;
        int selection = 0;
        if (human) {
            for (int i = 0; i < hands.size(); i++) {
                Hand hand = hands.get(i);
                if (hand.getStatus()) {
                    boolean valid = false;
                    while (!valid) {
                        System.out.println("Player " 
                            + this.player.getPlayerIndex() 
                            + " please make a move (hand " + i + ")");
                        boolean d = player.checkDouble();
                        selection = this.prompt(d);
                        if (selection == 3 || selection == 4) {
                            if (player.getCurrentBet() * 2 > player.getBalance()) {
                                String str = "";
                                if (selection == 3) {
                                    str = "Double Up";
                                } else if (selection == 4) {
                                    str = "Split";
                                }
                                System.out.println("Insufficient fund for " + str);
                                continue;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }

                    this.moves(selection, hand);
                    if (selection == 4) {
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < hands.size(); i++) {
                Hand hand = hands.get(i);
                if (hand.getStatus()) {
                    boolean d = player.checkDouble();
                    if (d && player.getCurrentBet() * 2 <= player.getBalance()) {
                        selection = 4;
                    } else {
                        if (hand.getTotalValue() >= 18) {
                            selection = 2;
                        } else if (hand.getTotalValue() >= 14
                            && player.getCurrentBet() * 2 <= player.getBalance()) {
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

    /**
     * A set of moves that can be done by a player
     */
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
                this.player.split();
                this.split();
                break;
        }
    }

    /**
     * Player takes another card
     */
    public void hit(Hand hand) {
        Card card = bt.getNextCard();
        card.flipCard(true);
        this.player.dealCards(card, hand);
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
        int bet = player.getCurrentBet();
        this.player.setBet(2*bet);
        Card card = bt.getNextCard();
        card.flipCard(true);
        this.player.dealCards(card, hand);
        hand.setStatus(false);
    }

    /**
     * Player splits into two hands. The two hands will move independently
     */
    public void split() {
        this.makeMove(human);
        player.printCards();
    }

    
}
