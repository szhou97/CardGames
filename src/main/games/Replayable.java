package games;

import structure.participant.Players;

public interface Replayable {
    
    public Players initPlayers();
    public void refreshPlayers(Players players);
}
