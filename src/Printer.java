import java.util.ArrayList;

public class Printer {
    public Printer() {

    }

    public void printTable(ArrayList<Player> players) {
        System.out.println("PRINTING CURRENT TABLE"
        + "*********************************************");
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
        final Object [][] table = new String[players.size() + 1][];
        table[0] = new String[] {"Player", "Role", "Games",
                                "Bet", "Balance", "Money Won"};
        
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            table[i + 1] = new String[] {
                Integer.toString(player.getPlayerIndex()), 
                player.getPlayerType(),
                Integer.toString(player.getGamesPlayed()),
                Integer.toString(player.getCurrentBet()),
                Integer.toString(player.getBalance()),
                Integer.toString(player.monDiff())
            };
        }

        for (final Object[] row : table) {
            System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s\n", row);
        }
    }
}
