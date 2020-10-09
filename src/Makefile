JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		CardType.java \
        Card.java \
        PlayerType.java \
        Player.java \
        Deck.java \
        GameTable.java \
        Main.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class