import java.util.Scanner;

public class inputPrompt {
    public inputPrompt() {

    }

    public void pressEnterPrompt() {
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    public int singleIntegerInput(int min, int max) {
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

    public int[] multipleIntegerInput(int minLength, int maxLength, int min, int max) {
        Scanner scan = new Scanner(System.in);
        int[] input = new int[maxLength];
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.MIN_VALUE;
        }
        while (true) {
            try {
                String[] str = scan.nextLine().split(",");
                if (str.length > input.length || str.length < minLength) {
                    throw new NumberFormatException();
                }
                for (int i = 0; i < str.length; i++) {
                    input[i] = Integer.parseInt(str[i]);
                    if (input[i] < min || input[i] > max) {
                        throw new NumberFormatException();
                    }
                }

                break;
            } catch (NumberFormatException nfe){
                System.err.println("Invalid input");
            }
        }
        return input;
    }
}