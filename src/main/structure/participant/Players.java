package structure.participant;

import java.util.ArrayList;

/**
 * The Players object contains a list of Player objects.
 */
public class Players {
    private ArrayList<Player> players;
    private Dealer dealer;

    public Players() {
        this.players = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void addDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public void remove(Player player) {
        this.players.remove(player);
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void resetPlayers() {
        // TODO
    }

    public String toString() {
        String str = "\n";
        str += "PLAYERS:\n";
        str += "name\t\tmoney won\n";
        for (Player player : getPlayers()) {
            str += player;
        }
        str += "\nDEALER\n";
        str += "name\t\tmoney won\n";
        str += dealer;
        return str;
    }

}
