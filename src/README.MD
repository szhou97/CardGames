# CS611Assignment3
Project: Blackjack

Author: Shuaike (Shawn) Zhou
szhou97@bu.edu
BUID: U77947592

Compilation and Execution Instructions:
After downloading the tar.gz file, execute the following commands:
```Bash
    tar -xvzf card_games.tar.gz
    cd main
    javac Main.java
    java Main
```

Participant Classes:
    
    Players.java:
        Contains a list of all the players including the dealer, and methods for modifying this list. 
    
    Participant, Player.java, Dealer.java:
        Where all the player information is stored. Participant stores generic information, Player stores a list of PlayerHands, and Dealer stores a single DealerHand.
    
    Hand.java, PlayerHand.java, DealerHand.java, CardGamePlayer.java:
        A class representing the hand of a player. Each hand maintains a set of card objects and the amount of bet placed on such set. PlayerHand stores the bet for the current hand, which is bonded by CardGamePlayer.java
    
Game Setup Classes:
    
    CardGameTable.java:
        This class inherits both abstract class GameTable.java and Interface TabeFunction.java, and it implements methods from both. 
    
    GameTable.java:
        The GameTable.java class contains necessary information for any game:
            A list of players/dealer;
            Methods to print out the player record/ current table;
        This class can be used for games like trianta ena and black jack.
    
    TableFunctions.java:
        This interface class contains methods necessary for any card games, modifying shoe, decks of cards, and return a random card from the deck when the corresponding method is called. A new deck is inserted into the shoe when original cards run out
    
    Shoe.java, Deck.java, Card.java, CardType.java, CartSuit.java:
        These classes representing a shoe of a cardgame. It contains a certain number of standart decks who are made up of cards. 
    

Helper Classes:

    input.java:
        Contains methods that take one or multiple integer inputs from the player when called.

    Printer.java:
        Contains methods that print the current record or table.

Workflow Classes:

    Main.java:
        Contains the start & end point of the program

    GameInitializer.java:
        Initializes the game by creating a new BlackJack.java object, and run repetitively unless stopped by the user. 

    CardGame.java, SumCardGames.java, CardGameMoves.java, MultiRoundGames.java:
        The SumCardGames.java extends CardGames.java and implements CardGameMoves.java and MultiRoundGames.java. More detailed description on the function of each class can be found as the file headers.
        Both TriantaEnaGame.java and BlackJackGame.java extends SumCardGames.java. SumCardGames.java includes most useful methods shared by the two games, and forces the games to implement their specific version of slightly different methods (such as two games have different winning/losing scenerios)
    
    Play.java, Replayable.java, PlayTriantaEna.java, PlayBlackJack.java:
        These classes work as the "driver" of the game classes. It takes player input specific of the game, starts the game, and modify participants as needed after each round of the game.
    
Some notable things:

    1. Though unnecessary, I changed many structural components of the original BlackJack program to make it more "object-oriented". Many ideas came from working on other's program in the previous Legends of Valor assignment. 

    2. Black Jack game no longer tracks the balance of a player/dealer. It only tracks how much money a player has won/lost throughout the entire game. A player can rack up a giant debt if does not quit willingly.

    3. Trianta Ena tracks both balance and money win/loss throughout the game. At the end of each iteration of the game, players/dealer with zero/negative balance are removed. In the case of a dealer's removal, the player with the highest balance will be forced to become the dealer in order for the game to continue.

    4. In Trianta Ena, after an iteration of the game, the players can rotate dealer as specified in the instruction.








