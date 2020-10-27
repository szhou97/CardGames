import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Players object contains a list of Player objects.
 */
public class Players implements Iterable<Player> {
    private ArrayList<Player> players;

    public Players(ArrayList<Player> players) {
        this.players = new ArrayList<Player>();
        for (int i = 0; i < players.size(); i++) {
            this.players.add(players.get(i));
        }
    }

    public void add(Player player) {
        this.players.add(player);
    }

    public void remove(Player player) {
        this.players.remove(player);
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void resetPlayers() {
        for (Player player : this.players) {
            player.clearHands();
        }
    }

    @Override
    public Iterator<Player> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}
