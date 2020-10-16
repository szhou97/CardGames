import java.util.ArrayList;

public class Players {
    private ArrayList<Player> players;
    private inputPrompt in;
    private Printer printer;
    public Players(ArrayList<Player> players) {
        this.players = new ArrayList<Player>();
        for (int i = 0; i < players.size(); i++) {
            this.players.add(players.get(i));
        }
        in = new inputPrompt();

    }

    public void add(Player player) {
        this.players.add(player);
    }

    public void remove(Player player) {
        this.players.remove(player);
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void participantsInformation() {
        System.out.println("Select the player(s) that you would like to use "
                        + "seperated by ',' \n"
                        + "Unselected dealer/player(s) will be controlled by ");
        
        int[] humanControlled = in.multipleIntegerInput(players.size(), 0, players.size());
        
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            for (int j = 0; j < humanControlled.length; j++) {
                if (player.getPlayerIndex() == humanControlled[j]) {
                    player.setHumanControl(true);
                    if (player.getPlayerType().equals("player")) {
                        if (player.getGamesPlayed() == 0) {
                            System.out.print("Player " + player.getPlayerIndex() + " :");
                            System.out.println("Please enter the total amount that " 
                                        + "you would like to enter today, "
                                        + "followed by the bet for the first "
                                        + "round, seperated by ',' \n");
                            int[] accInquiry = in.multipleIntegerInput(2,0,Integer.MAX_VALUE);
                            player.setBalance(accInquiry[0]);
                            player.setInitBalance(accInquiry[0]);
                            player.setBet(accInquiry[1]);
                            break;
                        } else {
                            System.out.println("Player " + player.getPlayerIndex()
                                            + "Please enter the amount of bet for "
                                            + "this round.");
                            player.setBet(in.singleIntegerInput(0,player.getBalance()));
                            break;
                        }
                    } else {
                        player.setBalance(100000000);
                        if (player.getGamesPlayed() == 0)
                            player.setInitBalance(100000000);
                        break;
                    }
                } else {
                    player.setHumanControl(false);
                    player.setBalance(100000000);
                    if (player.getGamesPlayed() == 0)
                        player.setInitBalance(100000000);
                    if (player.getPlayerType().equals("player"))
                        player.setBet(10);
                }
            }
        }
    }


}
