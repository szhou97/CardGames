public class Distributor {
    public static void distribute(Player player, Player dealer, boolean win) {
        int bet = player.getCurrentBet();
        if (win) {
            System.out.println("Player " + player.getPlayerIndex() 
                                + " wins " + 2*bet + " dollars!");
            player.winOrLose(2*bet);
            dealer.winOrLose(-(2*bet));
        } else {
            System.out.println("Player " + player.getPlayerIndex() 
                                + " loses " + bet + " dollars!");
            player.winOrLose(-bet);
            dealer.winOrLose(bet);
        }
    }
}
