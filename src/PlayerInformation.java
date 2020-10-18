import java.util.ArrayList;
/**
 * A class that is used to take bet/balance information at the beginning of 
 * each round of the game
 */
public class PlayerInformation {
    private ArrayList<Player> players;
    private inputPrompt in;

    public PlayerInformation(Players players) {
        this.in = new inputPrompt();
        this.players = players.getPlayers();
    }

    /**
     * Takes a list of players that the player likes to control manually
     */
    public void humanControlledPlayers() {
        System.out.println("Select the player(s) that you would like to use "
                        + "seperated by ',' \n"
                        + "Unselected dealer/player(s) will be controlled by "
                        + "the computer");
        int[] hc = in.multipleIntegerInput(1, players.size(), 0, players.size());
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            for (int j = 0; j < hc.length; j++) {
                if (player.getPlayerIndex() == hc[j]) {
                    player.setHumanControl(true);
                    break;
                }
            }
        }
    }
    /**
     * Set the bet and balance for a specific player
     * @param player
     */
    public void setBetAndBalance(Player player) {
        System.out.print("Player " + player.getPlayerIndex() + " :");
        System.out.println("Please enter the total amount that " 
                                        + "you would like to enter today, "
                                        + "followed by the bet for the first "
                                        + "round, seperated by ','");
        int[] accInquiry = in.multipleIntegerInput(2,2,0,Integer.MAX_VALUE);
        player.setBalance(accInquiry[0]);
        player.setInitBalance(accInquiry[0]);
        player.setBet(accInquiry[1]);
    }
    /**
     * Set the bet for a specific player
     */
    public void setBet(Player player) {
        System.out.println("Player " + player.getPlayerIndex()
                        + "Please enter the amount of bet for "
                        + "this round.");
        player.setBet(in.singleIntegerInput(0,player.getBalance()));
    }

    /**
     * Set the balance of a specific player
     */
    public void setBalance(Player dealer) {
        System.out.println("Dealer " + dealer.getPlayerIndex()
                        + "Please enter the total balance.");
        dealer.setBalance(in.singleIntegerInput(0, Integer.MAX_VALUE));
    }

    /**
     * Stores the collected information into Player's Account objects
     */
    public void participantsInformation() {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.humanControl()) {
                if (player.getPlayerType().equals("player")) {
                    if (player.getGamesPlayed() == 0) {
                        this.setBetAndBalance(player);
                    } else {
                        if (player.getBalance() == 0) {
                            System.out.println("Empty balance");
                            System.out.println("1: Continue with more money input\n"
                                + "2: Quit");
                            int sel = in.singleIntegerInput(1, 3);
                            if (sel == 1) {
                                this.setBetAndBalance(player);
                                player.setInitBalance(player.getBalance());
                            } else {
                                System.exit(0);
                            }
                        } else {
                            this.setBet(player);
                        }
                    }
                } else {
                    if (player.getGamesPlayed() == 0) {
                        this.setBalance(player);
                    } else {
                        if (player.getBalance() <= 0) {
                            System.out.println("THE CASINO HAS GONE BANKRUPT\n"
                                + "PROGRAM WILL SHUT DOWN");
                            System.exit(0);
                        }
                    }
                }
            } else {
                if (player.getGamesPlayed() == 0) {
                    player.setBalance(100000000);
                    player.setInitBalance(player.getBalance());
                    if (player.getPlayerType().equals("player")) {
                        player.setBet(200);
                    }
                } else {
                    if (player.getPlayerType().equals("player")) {
                        if (player.getBalance() <= 0) {
                            player.setBalance(100000000);
                            player.setInitBalance(player.getBalance());
                        } else {
                            player.setBet(10);
                        }
                    } else {
                        if (player.getBalance() <= 0) {
                            System.out.println("THE CASINO RAN OUT OF MONEY"
                                + "PROGRAM WILL SHUT DOWN");
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }
}
