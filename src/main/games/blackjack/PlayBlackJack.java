package games.blackjack;

import structure.participant.Players;
import structure.table.CardGameTable;

public class PlayBlackJack {
    private int numPlayers;
    public PlayBlackJack(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void Play() {
        Players players = initPlayers();
        CardGameTable table = new CardGameTable(players);
        BlackJackGame game = new BlackJackGame(table);
    }

    private Players initPlayers() {
        return null;
    }
}
