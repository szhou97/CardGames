import java.util.ArrayList;

public class Printer {
    public Printer() {

    }

    public void printTable(ArrayList<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            Player currP = players.get(i);
            System.out.println("Player " 
                            + currP.getPlayerIndex()
                            + " as "
                            + currP.getPlayerType());
            currP.printCards();
            System.out.println("");
        }
    }

    public void printRecord(ArrayList<Player> players) {
        System.out.println("Player    " 
                        + "Role      " 
                        + "Games Played     "
                        + "Games Won     " 
                        + "Current Bet    "
                        + "Current balance      "
                        + "Money Won/Loss");
        players.forEach((n) ->
            System.out.println(n.getPlayerIndex() + "         "
                        + n.getPlayerType() + "        "
                        + n.getGamesPlayed() + "                "
                        + n.getGamesWon() + "             "
                        + n.getCurrentBet() + "           "
                        + n.getBalance() + "              "
                        + n.monDiff())
        );
    }
}
