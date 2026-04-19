error id: file:///C:/flashcard/src/main/java/FlashcardGame.java
file:///C:/flashcard/src/main/java/FlashcardGame.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[84,13]

error in qdox parser
file content:
```java
offset: 2363
uri: file:///C:/flashcard/src/main/java/FlashcardGame.java
text:
```scala
import java.util.*;

import java.io.*;

public class FlashcardGame {

    private List<Card> cards = new ArrayList<>();
    private String file;
    private String order = "none";
    private int repetitions = 1;
    private boolean invert = false;

    public void setFile(String file) {
        this.file = file;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setRepetitions(int r) {
        this.repetitions = r;
    }

    public void setInvert(boolean invert) {
        this.invert = invert;
    }

   public void start() {
    load();
    CardOrganizer organizer = getOrganizer();
    Scanner sc = new Scanner(System.in);

    Map<Card, Integer> correctStreak = new LinkedHashMap<>();
    for (Card c : cards) {
        correctStreak.put(c, 0);
    }

    while (true) {
        List<Card> remaining = new ArrayList<>();
        for (Card c : cards) {
            if (correctStreak.get(c) < repetitions) {
                remaining.add(c);
            }
        }

        if (remaining.isEmpty()) break;

        remaining = organizer.organize(remaining);

        // Тойрог бүрт бүх картыг нэг нэгээр асуух
        for (Card c : new ArrayList<>(remaining)) {
            if (correctStreak.get(c) >= repetitions) continue;

            String q       = invert ? c.getAnswer()   : c.getQuestion();
            String correct = invert ? c.getQuestion()  : c.getAnswer();

            System.out.println("\nQ: " + q);
            System.out.print("Your answer: ");
            long start = System.currentTimeMillis();
            String ans = sc.nextLine();
            long elapsed = System.currentTimeMillis() - start;
            c.addResponseTime(elapsed);

            if (ans.equalsIgnoreCase(correct)) {
                System.out.println("✓ Correct!");
                c.markCorrect();
                correctStreak.put(c, correctStreak.get(c) + 1);
            } else {
                System.out.println("✗ Wrong! (Correct: " + correct + ")");
                c.markWrong();
                correctStreak.put(c, 0); // streak reset
            }
            c.incrementAsked();
        }
        // Тойрог дууссаны дараа дараагийн тойрогт эрэмбэлнэ
    }

    sc.close();
    showAchievements();
}
}

    private C@@ardOrganizer getOrganizer() {
        switch (order) {
            case "worst-first":
                return new WorstFirstSorter();
            case "recent-mistakes-first":
                return new RecentMistakesFirstSorter();
            case "random":
                return c -> { Collections.shuffle(c); return c; };
            default:
                return c -> c;
        }
    }

    private void load() {
        try (Scanner sc = new Scanner(new File(file))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] p = line.split("\\|");
                if (p.length >= 2) {
                    cards.add(new Card(p[0].trim(), p[1].trim()));
                }
            }
        } catch (Exception e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    private void showAchievements() {
        System.out.println("\n=== Achievements ===");

        boolean allCorrect = true;

        for (Card c : cards) {
            if (c.wasWrongLastTime()) {
            allCorrect = false;
            break;
            }
        }

        if (allCorrect) {
            System.out.println(" Achievement: CORRECT - Suuliin toirogt buh kart zov");
        }

        for (Card c : cards) {
            if (c.getAskedCount() > 5) {
                System.out.println("Achievement: REPEAT - Neg kartand 5-aas olon udaa hariulsan");
                break;
            }
        }

        for (Card c : cards) {
            if (c.getCorrectCount() >= 3) {
                System.out.println(" Achievement: CONFIDENT - Neg kartand 3 aas deesh udaa zov hariulsan");
                break;
            }
        }
        boolean speedrun = true;
            for (Card c : cards) {
            if (c.getAvgResponseTime() > 5000) {
                speedrun = false;
                break;
                }
            }
        if (speedrun) {
            System.out.println("Achievement: SPEEDRUN");
            }
    }
}
```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:560)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:691)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:688)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:688)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:940)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1090)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:614)
	java.base/java.lang.Thread.run(Thread.java:1474)
```
#### Short summary: 

QDox parse error in file:///C:/flashcard/src/main/java/FlashcardGame.java