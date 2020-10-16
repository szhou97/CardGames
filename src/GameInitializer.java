import java.util.Scanner;

public class GameInitializer {
    private boolean finished;
    private Printer printer;
    public GameInitializer() {
        this.finished = false;
        this.printer = new Printer();
    }

    public void start() {
        System.out.println("Welcome to BlackJack\n"
                        + "Please enter the number of players,"
                        + " excluding the dealer.");
        Scanner scan = new Scanner(System.in);
        while(true) {
            try {
                String in = scan.nextLine();
                int a = Integer.parseInt(in.trim());
                if (0 > a || a > 5) {
                    throw new NumberFormatException();
                } else {
                    this.run(a);
                } 
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid input. Minimum 1 player required"
                            + "Maximum 5 players");
            }
        }
    }
    
    public void run(int numPlayers) {
        while(!finished) {
            BlackJack bj = new BlackJack(numPlayers);
            bj.run();
        }
    }


}