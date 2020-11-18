package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PlayerInfoTaker {
    private File file;
    private int numPlayers;

    public PlayerInfoTaker(File file, int numPlayers) {
        this.file = file;
        this.numPlayers = numPlayers;
    }

    private int setBalance(int min, int max) {
        System.out.println("Please enter your balance.");
        return Input.integerInput(min, Integer.MAX_VALUE);
    }

    private int setBet(int balance) {
        System.out.println("Please enter your bet for this round. Minimum bet $10");
        return Input.integerInput(10, balance);
    }

    private int human(int index) {
        System.out.println("Would you like to control player " + index + "?");
        return Input.yesOrNo();
    }

    private void writeToFile(int[] info) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        for (int i : info) {
            out.print(i + ",");
        }
        out.print("\n");
        out.close();
    }

    private int dealerInfo() {
        System.out.println("Would you like to control the dealer?");
        return Input.yesOrNo();
    }

    public void takeInfo() throws IOException {
        int totalBet = 0;
        for (int i = 0; i < this.numPlayers; i++) {
            int[] info = new int[4];
            info[0] = i;
            info[1] = this.human(i);
            if (info[1] == 0) {
                info[2] = this.setBalance(10, 1000000);
                info[3] = this.setBet(info[2]);
            } else {
                info[2] = 10000;
                info[3] = 100;
            }
            totalBet += info[3];
            this.writeToFile(info);
        }
        int[] dealerInfo = new int[4];
        dealerInfo[0] = this.numPlayers;
        dealerInfo[1] = this.dealerInfo();
        if (dealerInfo[1] == 0) {
            dealerInfo[2] = this.setBalance(3*totalBet, Integer.MAX_VALUE);
        } else {
            dealerInfo[2] = 3*totalBet;
        }   
        dealerInfo[3] = 0;
        this.writeToFile(dealerInfo);
    }
}
