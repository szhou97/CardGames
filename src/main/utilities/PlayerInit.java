package utilities;

public class PlayerInit {

    private PlayerInit() {

    }

    public static int setBalance(int min, int max) {
        System.out.println("Please enter your balance.");
        return Input.integerInput(min, Integer.MAX_VALUE);
    }

    public static int setBet(int balance) {
        System.out.println("Please enter your bet for this round. Minimum bet $10");
        return Input.integerInput(10, balance);
    }

    public static int human(int index) {
        System.out.println("Would you like to control player " + index + "?");
        return Input.yesOrNo();
    }

    public static int dealerInfo() {
        System.out.println("Would you like to control the dealer?");
        return Input.yesOrNo();
    }
}
