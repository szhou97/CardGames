JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		CardType.java \
        CardSuit.java \
        Card.java \
        PlayerType.java \
        Hand.java \
        Account.java \
        Player.java \
        PlayerMoves.java \
        DealerMoves.java \
        Players.java \
        PlayerInformation.java \
        Deck.java \
        GameTable.java \
        CardGames.java \
        BlackJackTable.java \
        BlackJack.java \
        JudgeAndDistributor.java \
        inputPrompt.java \
        Printer.java \
        GameInitializer.java \
        Main.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class