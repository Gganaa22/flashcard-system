import java.util.*;
import java.io.*;

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

        Scanner sc = new Scanner(System.in);

        for (Card c : cards) {

            for (int i = 0; i < repetitions; i++) {

                String q = invert ? c.getAnswer() : c.getQuestion();
                String correct = invert ? c.getQuestion() : c.getAnswer();

                System.out.println("Q: " + q);
                System.out.print("Your answer: ");

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

        try (Scanner sc = new Scanner(new File(file))) {

            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split("\\|");
                cards.add(new Card(p[0], p[1]));
            }

        } catch (Exception e) {
            System.out.println("File error");
        }
    }

    private void showAchievements() {

        boolean allCorrect = true;

        for (Card c : cards) {
            if (c.getCorrectCount() == 0) {
                allCorrect = false;
            }
        }

        if (allCorrect) {
            System.out.println("🏆 Achievement: CORRECT");
        }

        for (Card c : cards) {
            if (c.getRepeatCount() > 5) {
                System.out.println("🏆 Achievement: REPEAT");
                break;
            }
        }

        for (Card c : cards) {
            if (c.getCorrectCount() >= 3) {
                System.out.println("🏆 Achievement: CONFIDENT");
                break;
            }
        }
    }
}