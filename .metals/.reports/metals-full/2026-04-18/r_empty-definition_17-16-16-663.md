error id: file:///C:/Users/DELL/OneDrive/文档/flashcard/FlashcardGame.java:java/util/stream/Stream#allMatch().
file:///C:/Users/DELL/OneDrive/文档/flashcard/FlashcardGame.java
empty definition using pc, found symbol in pc: java/util/stream/Stream#allMatch().
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 2071
uri: file:///C:/Users/DELL/OneDrive/文档/flashcard/FlashcardGame.java
text:
```scala
import java.util.*;

public class FlashcardGame {

    private List<Card> cards = new ArrayList<>();
    private String file;
    private String order = "random";
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

        if (order.equals("random")) {
            Collections.shuffle(cards);
        }

        if (order.equals("recent-mistakes-first")) {
            cards.sort((a, b) -> Boolean.compare(!a.wasWrongLastTime(), !b.wasWrongLastTime()));
        }

        Scanner sc = new Scanner(System.in);

        for (Card c : cards) {

            for (int i = 0; i < repetitions; i++) {

                String q = invert ? c.getAnswer() : c.getQuestion();
                String correct = invert ? c.getQuestion() : c.getAnswer();

                System.out.println("Q: " + q);
                String ans = sc.nextLine();

                if (ans.equalsIgnoreCase(correct)) {
                    System.out.println("? Correct");
                    c.markCorrect();
                } else {
                    System.out.println("? Wrong (Correct: " + correct + ")");
                    c.markWrong();
                }
            }
        }

        showAchievements();
    }

    private void load() {
        try (Scanner sc = new Scanner(new java.io.File(file))) {
            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split("\\|");
                cards.add(new Card(p[0], p[1]));
            }
        } catch (Exception e) {
            System.out.println("File error");
        }
    }

    private void showAchievements() {

        boolean allCorrect = cards.stream().allMatc@@h(c -> c.getCorrectCount() > 0);

        if (allCorrect) {
            System.out.println("🏆 CORRECT");
        }

        if (cards.stream().anyMatch(c -> c.getRepeatCount() > 5)) {
            System.out.println("🏆 REPEAT");
        }

        if (cards.stream().anyMatch(c -> c.getCorrectCount() >= 3)) {
            System.out.println("🏆 CONFIDENT");
        }
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/util/stream/Stream#allMatch().