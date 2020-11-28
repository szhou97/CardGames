package utilities;

import java.util.Scanner;
/**
 * A class dedicated to take input from the user
 */
public class Input {
    /**
     * Takes one ENTER key
     */
    public static void pressEnter() {
        System.out.println("Press enter to continue");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    public static boolean yesOrNo() {
        System.out.println("Please enter YES/no");
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        boolean answer = false;
        while (!valid) {
            String input = scan.nextLine();
            if (input.toLowerCase().trim().equals("yes")) {
                valid = true;
                answer = true;
            } else if (input.toLowerCase().trim().equals("no")) {
                valid = true;
                answer = false;
            } else {
                System.out.println("Unrecognized input, please enter again.");
            }
        }
        return answer;
    }

    /**
     * Takes an integer i that is min<i<max
     * @param min
     * @param max
     * @return
     */
    public static int integerInput(int min, int max) {
        System.out.println("Please enter a number between " 
            + min + " and " + max);
        Scanner scan = new Scanner(System.in);
        int input = 0;
        while(true) {
            try {
                String str = scan.nextLine();
                input = Integer.parseInt(str);
                if (input < min || input > max)
                    throw new NumberFormatException();
                break;
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid input");
            }
        }
        return input;
    }

    public static String stringInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}