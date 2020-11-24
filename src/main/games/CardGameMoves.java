package games;

import structure.participant.Hand;

public interface CardGameMoves {
    public void hit(Hand hand);
    public void stand(Hand hand);
}
