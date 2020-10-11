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
        Deck.java \
        GameTable.java \
        BlackJack.java \
        Main.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class