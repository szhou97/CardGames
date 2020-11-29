package structure.table;

import structure.participant.*;
/**
 * An abstract class that can be used for any game with a dealer and multiple
 * players. Contains method to initialize, update and print player information
 */
public abstract class GameTable {
    
    private Players players;

    public GameTable(Players players) {
        this.players = players;
    }

    public Players getPlayers() {
        return this.players;
    }
}
