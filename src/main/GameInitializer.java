/**
 * A class dedicated to run a game repetitively unless quit by the user
 */
public class GameInitializer {

    private boolean finished;
    private inputPrompt in;
    public GameInitializer() {
        this.finished = false;
        this.in = new inputPrompt();
    }

    /**
     * First start
     */
    public void start() {
        System.out.println("Welcome to BlackJack\n"
                        + "Please enter the number of players,"
                        + " excluding the dealer.\n"
                        + "1-5 players are allowed");
        this.run(in.singleIntegerInput(1, 5));
    }
    /**
     * Consequent starts
     * @return
     */
    public int restart() {
        System.out.println("Please select what to do next");
        System.out.println("1: Another game\n"
                        + "2: exit");
        return in.singleIntegerInput(1, 4);
    }

    /**
     * Running game repetitively
     */
    public void run(int numPlayers) {
        BlackJack bj = new BlackJack(numPlayers);
        bj.firstRun();
        while(!finished) {
            int selection = 0;
            selection = this.restart();
            if (selection == 1) {
                bj.run();
            } else if (selection == 2) {
                finished = true;
            }
        }
    }


}