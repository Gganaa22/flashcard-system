error id: file:///C:/Users/DELL/OneDrive/文档/flashcard/Main.java:java/io/PrintStream#println(+8).
file:///C:/Users/DELL/OneDrive/文档/flashcard/Main.java
empty definition using pc, found symbol in pc: java/io/PrintStream#println(+8).
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 127
uri: file:///C:/Users/DELL/OneDrive/文档/flashcard/Main.java
text:
```scala
public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.pr@@intln("Usage: flashcard <file> [options]");
            return;
        }

        if (args[0].equals("--help")) {
            System.out.println("""
                flashcard <file> [options]

                --order random | worst-first | recent-mistakes-first
                --repetitions <num>
                --invertCards
            """);
            return;
        }

        FlashcardGame game = new FlashcardGame();

        game.setFile(args[0]);

        for (int i = 1; i < args.length; i++) {

            switch (args[i]) {
                case "--order":
                    game.setOrder(args[++i]);
                    break;

                case "--repetitions":
                    game.setRepetitions(Integer.parseInt(args[++i]));
                    break;

                case "--invertCards":
                    game.setInvert(true);
                    break;
            }
        }

        game.start();
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/io/PrintStream#println(+8).