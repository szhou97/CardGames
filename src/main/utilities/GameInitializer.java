package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import games.blackjack.BlackJackGame;
import games.blackjack.PlayBlackJack;
import games.trianta.PlayTriantaEna;
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
                    + TriantaEnaGame.name + "\t" + "\t3: quit");
            int selection = Input.integerInput(1, 3);
            if (selection == 3) {
                end = true;
            } else {
                System.out.println("Please select the number of players, " + "excluding the dealer\n" + "Maximum 8 players");
                int numPlayers = Input.integerInput(1, 9);
                if (selection == 1) {
                    playBlackJack(numPlayers);
                } else if (selection == 2) {
                    playTriantaEna(numPlayers);
                }
            }
        }
    }

    /**
     * Running game repetitively
     */
    public void playBlackJack(int numPlayers) {
        PlayBlackJack game = new PlayBlackJack(numPlayers);
        boolean end = false;
        while (!end) {
            end = game.start();
        } 
    }

    public void playTriantaEna(int numPlayers) {
        PlayTriantaEna game = new PlayTriantaEna();
    }


}