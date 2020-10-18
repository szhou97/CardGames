import java.util.ArrayList;
/**
 *  The BlackJack class stores the actual game flow. It executes the game of 
 *  black jack when called
 */
public class BlackJack {

    private BlackJackTable blackJackTable;
    private ArrayList<Player> currPlayers;
    private Player dealer;
    private Printer printer;
    private PlayerInformation playerInfo;

    public BlackJack(int numPlayers) {
        this.currPlayers = new ArrayList<Player>();
        // Create a black jack table object, who contains players' information
        this.blackJackTable = new BlackJackTable(numPlayers);
        this.printer = new Printer();
        this.playerInfo = new PlayerInformation(this.blackJackTable.getPlayers());
    }
    /**
     * The first iteration of the game, where player gets to choose whether
     * to play or let computer play
     */
    public void firstRun() {
        this.playerInfo.humanControlledPlayers();
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
        this.run();
    }

    /**
     * The body of the game
     */
    public void run() {
        ArrayList<Player> players = this.blackJackTable.getPlayers().getPlayers();
        this.blackJackTable.getPlayers().resetPlayers();
        this.playerInfo.participantsInformation();
        this.blackJackTable.printRecords();
        this.blackJackTable.incrementGamesPlayed();

        JudgeAndDistributor jd = new JudgeAndDistributor(dealer);

        // Start off by dealer move
        DealerMoves dm = new DealerMoves(dealer, this.currPlayers, blackJackTable);
        int count = 0;
        while (count < 2) {
            if (dealer.humanControl())
                dm.makeMove(false);
            else
            {
                System.out.println("Dealer is dealing cards...");
                if (blackJackTable.deckSize() == 0) {
                    blackJackTable.newDeck();
                }
                dm.dealCards();
            }
            count++;
            printer.printTable(players);
        }

        // Check for bust players
        for (Player player : currPlayers) {
            jd.bust(player);
        }

        boolean end = false;
        // Player moves until end condition is met
        while (!end) {
            end = true;
            for (int i = 0; i < this.currPlayers.size(); i++) {
                Player player = this.currPlayers.get(i);
                if (player.getStatus()) {
                    end = false;     // Ends if all player status returns false

                    // A new deck of cards is generated in the case of cards
                    // running out
                    if (blackJackTable.deckSize() == 0) {
                        blackJackTable.newDeck();
                    }
                    PlayerMoves pm = new PlayerMoves(player, this.blackJackTable);
                    pm.makeMove(player.humanControl());
                    jd.bust(player);
                }
            }
            if (end) {
                break;
            } else {
                printer.printTable(players);
            }
        }
        boolean valid = false;
        // Check if judge and distributo required 
        // (iff there is a player whose score <= 21)
        for (Player player : currPlayers) {
            for (Hand hand : player.getHands()) {
                if (hand.getTotalValue() <= 21) {
                    valid = true;
                    break;
                }
            }
        }
        // Dealer moves
        if (valid) {
            Hand hand = dealer.getHands().get(0);
            System.out.println("Dealer will flip the second card.");
            hand.flipLastCard();
            printer.printTable(players);
            // Hit until 17
            while(hand.getTotalValue() < 17) {
                if (blackJackTable.deckSize() == 0) {
                    blackJackTable.newDeck();
                }
                if (dealer.humanControl())
                    dm.makeMove(true);
                else   
                    dm.hit();
                printer.printTable(players);
            }
        }
        // Check for winners use the judge and distributor and distribute
        // funds if necessary
        jd.checkWinner(currPlayers);
        printer.printRecord(players);
    }
}
