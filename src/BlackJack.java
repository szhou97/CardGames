import java.util.ArrayList;

public class BlackJack {

    private BlackJackTable blackJackTable;
    private ArrayList<Player> currPlayers;
    private Player dealer;
    private Printer printer;
    private PlayerInformation playerInfo;
    public BlackJack(int numPlayers) {
        this.currPlayers = new ArrayList<Player>();
        this.blackJackTable = new BlackJackTable(numPlayers);
        this.printer = new Printer();
        this.playerInfo = new PlayerInformation(this.blackJackTable.getPlayers());
    }
    public void firstRun() {
        ArrayList<Player> players = this.blackJackTable.getPlayers().getPlayers();
        this.playerInfo.humanControlledPlayers();
        this.run();
    }
    public void run() {
        this.blackJackTable.getPlayers().resetPlayers();
        ArrayList<Player> players = this.blackJackTable.getPlayers().getPlayers();
        
        this.playerInfo.participantsInformation();
        this.blackJackTable.printRecords();
        this.blackJackTable.incrementGamesPlayed();

        // Ensure a new deck is available at the start of each round
        if (this.blackJackTable.deckSize() != 52) 
            this.blackJackTable.newDeck();
        // Loop through the roster, seperate the dealer from the rest
        // of the players
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPlayerType().equals("dealer")) {
                this.dealer = players.get(i);
            } else {
                this.currPlayers.add(players.get(i));
            }
        }

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
        for (Player player : currPlayers) {
            for (Hand hand : player.getHands()) {
                if (hand.getTotalValue() <= 21) {
                    valid = true;
                    break;
                }
            }
        }
        if (valid) {
            Hand hand = dealer.getHands().get(0);
            System.out.println("Dealer will flip the second card.");
            hand.flipLastCard();
            printer.printTable(players);

            while(hand.getTotalValue() < 17) {
                if (dealer.humanControl())
                    dm.makeMove(true);
                else   
                    dm.hit();
                printer.printTable(players);
            }
            jd.checkWinner(currPlayers);
        }

        printer.printRecord(players);
    }
}
