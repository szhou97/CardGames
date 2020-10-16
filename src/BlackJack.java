import java.util.ArrayList;

public class BlackJack {

    private BlackJackTable blackJackTable;
    private ArrayList<Player> currPlayers;
    private Player dealer;
    private Printer printer;
    public BlackJack(int numPlayers) {
        this.currPlayers = new ArrayList<Player>();
        this.blackJackTable = new BlackJackTable(numPlayers);
        this.printer = new Printer();
    }
    
    public void checkWinner() {

    }
    

    public boolean check21(Player player) {
        boolean blackjack = false;
        ArrayList<Hand> hands = new ArrayList<Hand>();
        hands = player.getHands();
        for (int i = 0; i < hands.size(); i++) {
            if (hands.get(i).getTotalValue() == 21) {
                blackjack = true;
                player.setStatus(false);
                System.out.println("Player " 
                            + player.getPlayerIndex()
                            + " hit BlackJack!");
            }
        }
        return blackjack;
    }

    public int run() {

        // Collect user information
        this.blackJackTable.getPlayers().participantsInformation();

        // Ensure a new deck is available at the start of each round
        this.blackJackTable.printRecords();
        if (this.blackJackTable.deckSize() != 52) 
            this.blackJackTable.newDeck();
        ArrayList<Player> players = this.blackJackTable.getPlayers().getPlayers();
        // Loop through the roster, seperate the dealer from the rest
        // of the players
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPlayerType().equals("dealer")) {
                this.dealer = players.get(i);
            } else {
                this.currPlayers.add(players.get(i));
            }
        }

        // Start off by dealer move
        DealerMoves dm = new DealerMoves(dealer, this.currPlayers, blackJackTable);
        int count = 0;
        while (count < 2) {
            if (dealer.humanControl())
                dm.makeMove(false);
            else
            {
                System.out.println("Dealer is dealing cards...");
                dm.dealCards();
            }

            count++;
            printer.printTable(players);
        }
        boolean end = false;
        while (!end) {
            end = true;
            for (int i = 0; i < this.currPlayers.size(); i++) {
                Player player = this.currPlayers.get(i);
                if (player.getStatus()) {
                    end = false;     
                    PlayerMoves pm = new PlayerMoves(player, this.blackJackTable);
                    pm.makeMove(player.humanControl());
                }
            }
            printer.printTable(players);
        }


        return 0;
    }
}
