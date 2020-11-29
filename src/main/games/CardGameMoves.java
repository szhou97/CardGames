package games;

import structure.participant.*;

public interface CardGameMoves {
    public void hit(Hand hand);
    public void stand(Hand hand);
    public boolean isBust(Hand hand);
    public boolean isWin(Hand hand);
    public boolean isNatural(Hand hand);
    public void checkWinner();
}
