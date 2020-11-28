package utilities;

public class PlayerInit {

    private PlayerInit() {

    }

    public static String setName() {
        System.out.println("Please enter your name");
        return Input.stringInput();
    }

    public static int setBalance(int min, int max) {
        System.out.println("Please enter your balance.");
        return Input.integerInput(min, Integer.MAX_VALUE);
    }

    public static int setBet(int balance) {
        System.out.println("Please enter your bet for this round.");
        return Input.integerInput(10, balance);
    }

    public static boolean human() {
        System.out.println("Would you like to control this player?");
        return Input.yesOrNo();
    }

    public static boolean dealerInfo() {
        System.out.println("Would you like to control the dealer?");
        return Input.yesOrNo();
    }
}
