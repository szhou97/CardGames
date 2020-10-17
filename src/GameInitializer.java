
public class GameInitializer {

    private boolean finished;
    private inputPrompt in;
    public GameInitializer() {
        this.finished = false;
        this.in = new inputPrompt();
    }

    public void start() {
        System.out.println("Welcome to BlackJack\n"
                        + "Please enter the number of players,"
                        + " excluding the dealer.");
        this.run(in.singleIntegerInput(1, 5));
    }
    
    public int restart() {
        System.out.println("Please select what to do next");
        System.out.println("1: Another game\n"
                        + "2: exit");
        return in.singleIntegerInput(1, 4);
    }

    public void run(int numPlayers) {
        BlackJack bj = new BlackJack(numPlayers);
        while(!finished) {
            bj.run();
            int selection = 0;
            selection = this.restart();
            if (selection == 1) {
                continue;
            } else if (selection == 2) {
                finished = true;
            }
        }
    }


}