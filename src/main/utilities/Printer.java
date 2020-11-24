package utilities;

import java.util.ArrayList;
/**
 * The printer class prints the current table or record 
 * according to given format
 */
public class Printer {
    // public static void printTable(ArrayList<Player> players) {
    //     System.out.println(
    //         "***********************"
    //         + "PRINTING CURRENT TABLE"
    //         + "***********************");
    //     System.out.println("");
    //     for (int i = 0; i < players.size(); i++) {
    //         Player currP = players.get(i);
    //         System.out.println("Player " 
    //                         + currP.getPlayerIndex()
    //                         + " as "
    //                         + "player");
    //         currP.printPlayer();
    //         System.out.println("");
    //     }
    //     System.out.println(
    //         "***********************"
    //         + "FINISHED CURRENT TABLE"
    //         + "***********************");
    // }
    //
    // public static void printRecord(ArrayList<Player> players) {
    //     final Object [][] table = new String[players.size() + 1][];
    //     table[0] = new String[] {"Player", "Role", "Games",
    //                             "Bet", "Balance", "Total Win/Loss"};
        
    //     for (int i = 0; i < players.size(); i++) {
    //         Player player = players.get(i);
    //         String str = "";
    //         if (player.isHuman()) {
    //             str = "Current P" + player.getPlayerIndex();
    //         } else {
    //             str = Integer.toString(player.getPlayerIndex());
    //         }
    //         table[i + 1] = new String[] {
    //             str, 
    //             "player",
    //             Integer.toString(player.getGamesPlayed()),
    //             Integer.toString(player.getCurrentBet()),
    //             Integer.toString(player.getBalance()),
    //             Integer.toString(player.getTotal())
    //         };
    //     }
    //     System.out.print("***********************************************");
    //     System.out.println("***********************************************");

    //     for (final Object[] row : table) {
    //         System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s\n", row);
    //     }
    //     System.out.print("***********************************************");
    //     System.out.println("***********************************************");

    // }
}
