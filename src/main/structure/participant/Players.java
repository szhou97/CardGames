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
            str += player + "\n";
        }
        str += "\nDEALER\n";
        str += "name\t\tmoney won\n";
        str += dealer + "\n";
        return str;
    }

    public String toString(boolean balance) {
        String str = "\n";
        str += "PLAYERS:\n";
        str += "name\t\t\tmoney won\t\t\tbalance\n";
        for (Player player : getPlayers()) {
            str += player + "\t\t\t" + player.getBalance() + "\n";
        }
        str += "\nDEALER\n";
        str += "name\t\tmoney won\t\tbalance\n";
        str += dealer + "\t\t\t" + dealer.getBalance() + "\n";
        return str;
    }

}
