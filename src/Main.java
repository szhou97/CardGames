import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                    BlackJack blackJack = new BlackJack(a);
                    blackJack.init();
                } 
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid input. Minimum 1 player required"
                            + "Maximum 5 players");
            }
        }
    }
}
