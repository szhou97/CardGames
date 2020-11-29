package games.trianta;

import games.CardGame;
import structure.participant.Players;
import structure.table.CardGameTable;
import utilities.Input;
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
    public void checkWinner(Players players) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean play() {
        // Deal first round of cards and ask for bet input
        return Input.yesOrNo();
    }
}
