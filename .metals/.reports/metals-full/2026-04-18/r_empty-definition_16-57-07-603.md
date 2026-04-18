error id: file:///C:/Users/DELL/OneDrive/文档/flashcard/Main.java:
file:///C:/Users/DELL/OneDrive/文档/flashcard/Main.java
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 356
uri: file:///C:/Users/DELL/OneDrive/文档/flashcard/Main.java
text:
```scala
public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: flashcard <file>");
            return;
        }

        if (args[0].equals("--help")) {
            System.out.println("flashcard <cards-file>");
            return;
        }

        FlashcardGame game@@ = new FlashcardGame();
        game.start(args[0]);
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 