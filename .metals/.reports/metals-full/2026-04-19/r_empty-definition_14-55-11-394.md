error id: file:///C:/Users/DELL/OneDrive/文档/flashcard/FlashcardGame.java:javax/smartcardio/Card#getWrongCount#
file:///C:/Users/DELL/OneDrive/文档/flashcard/FlashcardGame.java
empty definition using pc, found symbol in pc: javax/smartcardio/Card#getWrongCount#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 3352
uri: file:///C:/Users/DELL/OneDrive/文档/flashcard/FlashcardGame.java
text:
```scala
import java.util.*;

import javax.smartcardio.Card;

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

            for (Card c : remaining) {
                if (correctStreak.get(c) >= repetitions) continue;

                String q       = invert ? c.getAnswer()  : c.getQuestion();
                String correct = invert ? c.getQuestion() : c.getAnswer();

                System.out.println("\nQ: " + q);
                System.out.print("Your answer: ");
                String ans = sc.nextLine();

                if (ans.equalsIgnoreCase(correct)) {
                    System.out.println("✓ Correct!");
                    c.markCorrect();
                    correctStreak.put(c, correctStreak.get(c) + 1);
                } else {
                    System.out.println("✗ Wrong! (Correct: " + correct + ")");
                    c.markWrong();
                    correctStreak.put(c, 0);
                }
                c.incrementAsked();
            }
        }

        showAchievements();
    }

    private CardOrganizer getOrganizer() {
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
            if (c.getWrongC@@ount() > 0 && c.getCorrectCount() == 0) {
                allCorrect = false;
                break;
            }
            if (c.getCorrectCount() == 0) {
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


#### Short summary: 

empty definition using pc, found symbol in pc: javax/smartcardio/Card#getWrongCount#