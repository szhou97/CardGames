import java.util.ArrayList;

public class PlayerInformation {

    private ArrayList<Player> players;
    private inputPrompt in;

    public PlayerInformation(Players players) {
        this.players = players.getPlayers();
        this.in = new inputPrompt();
    }

    public void humanControlledPlayers() {
        System.out.println("Select the player(s) that you would like to use "
                        + "seperated by ',' \n"
                        + "Unselected dealer/player(s) will be controlled by ");
        int[] humanControlled = in.multipleIntegerInput(1, players.size(), 
                                                    0, players.size());
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            for (int j = 0; j < humanControlled.length; j++) {
                if (player.getPlayerIndex() == humanControlled[j]) {
                    player.setHumanControl(true);
                } else {
                    player.setHumanControl(false);
                }
            }
        }
    }

    public void setBetAndBalance(Player player) {
        System.out.print("Player " + player.getPlayerIndex() + " :");
        System.out.println("Please enter the total amount that " 
                                        + "you would like to enter today, "
                                        + "followed by the bet for the first "
                                        + "round, seperated by ',' \n");
        int[] accInquiry = in.multipleIntegerInput(2,2,0,Integer.MAX_VALUE);
        player.setBalance(accInquiry[0]);
        player.setInitBalance(accInquiry[0]);
        player.setBet(accInquiry[1]);
    }

    public void setBet(Player player) {
        System.out.println("Player " + player.getPlayerIndex()
                        + "Please enter the amount of bet for "
                        + "this round.");
        player.setBet(in.singleIntegerInput(0,player.getBalance()));
    }

    public void participantsInformation(int[] humanControlled) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getPlayerType().equals("player")) {
                if (player.humanControl()) {
                    if (player.getGamesPlayed() == 0) {
                        this.setBetAndBalance(player);
                        break;
                    } else {
                        this.setBet(player);
                        break;
                    }
                } else {
                    player.setBalance(100000000);
                    if (player.getGamesPlayed() == 0)
                        player.setInitBalance(100000000);
                    break;
                }
            } else {
                player.setBalance(100000000);
                if (player.getGamesPlayed() == 0)
                    player.setInitBalance(100000000);
                if (player.getPlayerType().equals("player"))
                    player.setBet(10);
            }
        }
    }
}
