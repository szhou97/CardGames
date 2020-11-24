package games.trianta;

import games.CardGame;
import structure.table.CardGameTable;
import utilities.TextColors;

public class TriantaEnaGame extends CardGame {
    public static String name = 
        TextColors.ANSI_YELLOW 
        + "Trianta Ena" 
        + TextColors.ANSI_RESET;
    public TriantaEnaGame(CardGameTable table) {
        super(table);

    }

    @Override
    public void checkWinner() {
        // TODO Auto-generated method stub

    }
}
