package games.blackjack;

import java.util.ArrayList;

import games.*;
import participant.*;
import utilities.*;
/**
 *  The BlackJack class stores the actual game flow. It executes the game of 
 *  black jack when called
 */
public class BlackJack {
    public static String name = 
        TextColors.ANSI_GREEN 
        + "BlackJack" 
        + TextColors.ANSI_RESET;
        
    private CardGameTable blackJackTable;
    private ArrayList<Player> currPlayers;
    private Player dealer;
    private Moves moves;

    public BlackJack(Players players) {
        this.currPlayers = new ArrayList<Player>();
        // Create a black jack table object, who contains players' information
        this.blackJackTable = new CardGameTable(players);
        this.moves = new Moves(this.blackJackTable);
    }

    /**
     * The body of the game
     */
    public void run() {
        ArrayList<Player> players = this.blackJackTable.getPlayers().getPlayers();
        this.blackJackTable.getPlayers().resetPlayers();
        this.blackJackTable.printRecords();
        this.blackJackTable.incrementGamesPlayed();
    }
}
