package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import games.blackjack.BlackJackGame;
import games.trianta.TriantaEnaGame;
import structure.participant.*;

/**
 * A class dedicated to run a game repetitively unless quit by the user
 */
public class GameInitializer {

    private boolean finished;

    public GameInitializer() {

    }

    /**
     * First start
     */
    public void start() {
        boolean end = false;
        while (!end) {
            System.out.println("Please choose a game to play:\n" + "\t1: " + BlackJackGame.name + "\t" + "\t2: "
                    + TriantaEnaGame.name + "\t");
            int selection = Input.integerInput(1, 2);
            System.out.println("Please select the number of players, " + "excluding the dealer\n" + "Maximum 5 players");
            int numPlayers = Input.integerInput(1, 7);
        }
    }

    /**
     * Running game repetitively
     */
    public void playBlackJack(Players players) {

    }

    public void playTriantaEna(Players players) {

    }


}