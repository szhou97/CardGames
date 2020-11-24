package games.blackjack;

import java.util.ArrayList;

import games.*;
import structure.cards.Card;
import structure.participant.*;
import structure.table.CardGameTable;
import utilities.*;
/**
 *  The BlackJack class stores the actual game flow. It executes the game of 
 *  black jack when called
 */
public class BlackJackGame extends SumCardGame {
    public static String name = 
        TextColors.ANSI_GREEN 
        + "BlackJack" 
        + TextColors.ANSI_RESET;
        
    private ArrayList<Player> currPlayers;
    private Player dealer;

    public BlackJackGame(CardGameTable table, Players players) {
        super(table);
        this.currPlayers = new ArrayList<Player>();
        // Create a black jack table object, who contains players' information
    }

    /**
     * The body of the game
     */
    public void play() {
        
    }

    @Override
    public void checkWinner() {
        // TODO Auto-generated method stub

    }

     /**
     * Player doubles bet, then hit and stand
     */
    public void doubleUp(PlayerHand hand) {
        hand.setBet(hand.getBet() * 2);
        hit(hand);
        stand(hand);
    }

    /**
     * Player splits into two hands. The two hands will move independently
     */
    public void split(Player player, Hand hand) {
        //player.split(hand);
    }
}
