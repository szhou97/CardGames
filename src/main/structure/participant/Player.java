package structure.participant;

/**
 * The player object contains a PlayerType object, an Account object and 
 * 1-2 Hand object depending on player moves during the game. It serves 
 * the purpose of storing/updating any information related to a single 
 * player
 */
public class Player extends Participant {
    private PlayerManager manager;

    public Player(int index, int human, int balance, int bet) {
        super(index, human, balance);
    }

    public PlayerManager getPlayerManager() {
        return manager;
    }
    
    public String toString() {
        
        return getPlayerIndex() + "\t\t" + getPlayerManager().toString();
    }
}
