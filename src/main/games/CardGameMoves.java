package games;

import structure.participant.*;

public interface CardGameMoves {
    public void hit(Hand hand);
    public void stand(Hand hand);
    public void tie(Player player, Dealer dealer, PlayerHand hand);
    public void win(Player player, Dealer dealer, PlayerHand hand);
    public void lose(Player player, Dealer dealer, PlayerHand hand);
    
}
