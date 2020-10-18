# CS611Assignment3
Project: Blackjack

Author: Shuaike (Shawn) Zhou
szhou97@bu.edu
BUID: U77947592

Compilation and Execution Instructions:
Using terminal, execute the following commands:
    make clean
    make
    java Main.java

Player Classes:
    
    Players.java:
        Contains a list of all the players including the dealer, and methods for modifying this list. 
    
    Player.java:
        Where all the player information is stored
    
    PlayerType.java:
        Stores the player's type. In this program, only "player"/"dealer" are available
    
    Account.java:
        Stores the financial information for a player (bet, balance, money win/loss)
    
    Hand.java:
        A class representing the hand of a player. Each hand maintains a set of card objects and the amount of bet placed on such set.
    
    PlayerMoves.java, DealerMoves.java:
        These two classes represent the possible moves that can be performed by a player/dealer. When a player object is passed in, it performs the move on the player's hand by player input.
    
Game Setup Classes:
    
    BlackJack.java:
        The actual class where all the game flow takes place. It creates a BlackJackTable.java class when first created. 
    
    BlackJackTable.java:
        This class inherits both abstract class GameTable.java and Interface CardGames.java, and it implements methods from both. 
    
    GameTable.java:
        The GameTable.java class contains necessary information for any game:
            A list of players/dealer;
            Methods to print out the player record/ current table;
        This class can be used for other games as well.
    
    CardGames.java:
        This interface class contains methods necessary for any card games, modifying decks of cards, and return a random card from the deck when the corresponding method is called.
    
    Deck.java:
        A class representing a standard 52 cards deck. While the cards are not shuffled, the getNextCard() method removes and returns a random card from the deck.
    
    Card.java:
        A class representing a standard card. It contains CardType and CardSuit information, and has a method returning the value of the card.
    
    CardType.java:
        Contains information on cards' types: 2-9, A, J, Q, K
    
    CardSuit.java:
        Contains information on cards' suits: Clubs, Hearts, Diamonds, Spades

Helper Classes:

    inputPrompt.java:
        Contains methods that take one or multiple integer inputs from the player when called.

    Printer.java:
        Contains methods that print the current record or table.

Workflow Classes:

    Main.java:
        Contains the start & end point of the program

    GameInitializer.java:
        Initializes the game by creating a new BlackJack.java object, and run repetitively unless stopped by the user. 

    BlackJack.java:
        The actual body of the game
    
    JudgeAndDistributor.java:
        This class decides the winner/loser of the current round of game and consequently gives/takes money.
    








