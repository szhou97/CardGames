/******************************************************************************
 * Class: GameInitializer
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/
package utilities;

import games.blackjack.BlackJackGame;
import games.blackjack.PlayBlackJack;
import games.trianta.PlayTriantaEna;
import games.trianta.TriantaEnaGame;

/**
 * A class dedicated to choose a game or run a game repetitively unless quit by the user
 */
public class GameInitializer {
    public GameInitializer() {

    }

    public void start() {
        boolean end = false;
        while (!end) {
            System.out.println("Please choose a game to play:\n" + "\t1: " 
                + BlackJackGame.name + "\t" + "\t2: "
                + TriantaEnaGame.name + "\t" + "\t3: quit");
            int selection = Input.integerInput(1, 3);
            if (selection == 3) {
                end = true;
            } else {
                System.out.println("Please select the number of players, " 
                    + "excluding the dealer\n" 
                    + "Maximum 8 players");
                int numPlayers = Input.integerInput(1, 9);
                if (selection == 1) {
                    playBlackJack(numPlayers);
                } else if (selection == 2) {
                    playTriantaEna(numPlayers);
                }
            }
        }
    }

    public void playBlackJack(int numPlayers) {
        System.out.print("\n\n\t\tWelcome to Black Jack\n\n");
        PlayBlackJack game = new PlayBlackJack(numPlayers);
        game.start();
    }

    public void playTriantaEna(int numPlayers) {
        System.out.print("\n\n\t\tWelcome to Trianta Ena\n\n");
        PlayTriantaEna game = new PlayTriantaEna(numPlayers);
        game.start();
    }


}