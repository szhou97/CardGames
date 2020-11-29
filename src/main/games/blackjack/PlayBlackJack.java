package games.blackjack;

import games.Play;
import games.Replayable;
import structure.participant.*;
import structure.table.*;
import utilities.*;


public class PlayBlackJack extends Play implements Replayable {
    public PlayBlackJack(int numPlayers) {
        super(numPlayers);
    }

    public void start() {
        Players players = initPlayers();
        CardGameTable table = new CardGameTable(players, BlackJackRules.NUM_DECKS);
        System.out.println("Current players on the table: ");
        System.out.println(table.getPlayers());
        System.out.println("The game will begin now. Good Luck!!");
        Input.pressEnter();
        BlackJackGame game = new BlackJackGame(table);
        boolean play = true;
        while(play) {
            play = game.play();
            if (play) {
                refreshPlayers(players);
            }
        }
    }

    @Override
    public Players initPlayers() {
        Players players = new Players();
        for (int i = 0; i < getNumPlayers(); i++) {
            boolean done = false;
            while(!done) {
                Player player = createPlayer(i + 1);
                player.setBalance(100000);
                int bet = PlayerInit.setBet(player.getBalance());
                System.out.println("Player details: ");
                System.out.println("name: " + player.getName() + ", bet: " + bet);
                System.out.println("Confirm?");
                if (Input.yesOrNo()) {
                    player.placeNewBet(bet);
                    players.addPlayer(player);
                    done = true;
                } 
            }
        }
        boolean done = false;
        Dealer dealer = null;
        while (!done) {
            if (PlayerInit.dealerInfo()) {
                dealer = createDealer();
                dealer.setBalance(100000);
                System.out.println("Dealer details: ");
                System.out.println("name: " + dealer.getName());
                System.out.println("Confirm?");
                if (Input.yesOrNo()) {
                    players.addDealer(dealer);
                    done = true;
                }
            } else {
                String name = "dealer";
                dealer = new Dealer(name);
                players.addDealer(dealer);
                done = true;
            }
        }
        return players;
    }
}
