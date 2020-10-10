import java.util.ArrayList;

public class BlackJack extends GameTable {
    private ArrayList<Player> currPlayers;
    private Player dealer;
    public BlackJack(int numPlayers) {
        super(numPlayers);
    }

    @Override
    public int init() {
        // Ensure a new deck is available at the start of each round
        if (this.deckSize() != 52) 
            this.newDeck();
        
        this.currPlayers = this.getPlayers();
        for (int i = 0; i < this.currPlayers.size(); i++) {
            if (this.currPlayers.get(i).getPlayerType().equals("dealer")) {
                this.dealer = this.currPlayers.get(i);
                break;
            }
        }
        System.out.println("Select the player(s) that you would like to use\n"
                        + "seperated by ',' \n"
                        + "Unselected dealer/player(s) will be controlled by\n"
                        + "the computer");
        this.startGame();
        return 0;
    }

    public int inputPrompt() {
        return 0;
    }

    public void startGame() {
        int count = 0;
        boolean faceUp = true;
        while (count < 2) {
            for (int i = 0; i < this.currPlayers.size(); i++) {
                Player player = this.currPlayers.get(i);
                if (player.getPlayerType().equals("player"))
                    this.dealCard(player, faceUp);
            }
            if (count == 1) 
                faceUp = false;
            this.dealCard(this.dealer, faceUp);
            this.printTable();
            count++;
        }
    }

    public int dealerMove(Player dealer, boolean human) {
        return 0;
    }

    public int playerMove(Player player, boolean human) {
        return 0;
    }
}
