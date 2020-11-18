package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import games.blackjack.BlackJack;
import participant.*;

import games.blackjack.BlackJack;
import games.trianta.Trianta;
import participant.Player;
import participant.Player;

/**
 * A class dedicated to run a game repetitively unless quit by the user
 */
public class GameInitializer {

    private boolean finished;

    public GameInitializer() {

    }

    private Players loadPlayers(File file, int numPlayers) throws FileNotFoundException {
        Players players = new Players();
        Scanner reader = new Scanner(file);
        int count = 0;
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] info = line.split(",");
            int index = Integer.parseInt(info[0].replace(",", ""));
            int human = Integer.parseInt(info[1].replace(",", ""));
            int balance = Integer.parseInt(info[2].replace(",", ""));
            int bet = Integer.parseInt(info[3].replace(",", ""));
            if (count < numPlayers)
                players.add(new Player(index, human, balance, bet));
            else
                players.addDealer(new Dealer(index, human, balance));
            count++;
        }
        return players;
    }

    /**
     * First start
     */
    public void start() {
        boolean end = false;
        while (!end) {
            System.out.println("Please choose a game to play:\n" + "\t1: " + BlackJack.name + "\t" + "\t2: "
                    + Trianta.name + "\t");

            int selection = Input.integerInput(1, 2);
            System.out.println("Please select the number of players, " + "excluding the dealer\n" + "Maximum 5 players");

            int numPlayers = Input.integerInput(1, 5);
            File file = new File("player.txt");
            try {
                file.createNewFile();
                PlayerInfoTaker pif = new PlayerInfoTaker(file, numPlayers);
                pif.takeInfo();
                Players players = this.loadPlayers(file, numPlayers);
                if (selection == 1) {
                    this.playBlackJack(players);
                } else if (selection == 2) {
                    this.playTriantaEna(players);
                }
            } catch (IOException e) {
                System.err.println("File could not be created");
            }
            file.delete();
        }
    }

    /**
     * Running game repetitively
     */
    public void playBlackJack(Players players) {
        BlackJack blackJack = new BlackJack(players);
        blackJack.run();
    }

    public void playTriantaEna(Players players) {

    }


}