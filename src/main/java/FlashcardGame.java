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
            String ans = sc.nextLine().trim();
            long elapsed = System.currentTimeMillis() - start;
            c.addResponseTime(elapsed);

            
            if (ans.equalsIgnoreCase("q") || ans.equalsIgnoreCase("quit")) {
                System.out.println("Программ зогслоо.");
                sc.close();
                showAchievements();
                return;
                }

            if (ans.equalsIgnoreCase(correct)) {
                System.out.println(" Correct!");
                c.markCorrect();
                correctStreak.put(c, correctStreak.get(c) + 1);
            } else {
                System.out.println(" Wrong! (Correct: " + correct + ")");
                c.markWrong();
                 
            }
            c.incrementAsked();
        }
        System.out.println("\n------------------");
        
    }

    sc.close();
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

    // CORRECT: сүүлийн тойрогт  бүх карт зөв хариулсан
    boolean allCorrect = true;
    for (Card c : cards) {
        if (c.wasWrongLastTime()) {
            allCorrect = false;
            break;
        }
    }
    if (allCorrect) {
        System.out.println("Achievement: CORRECT");
    }

    // REPEAT: нэг картад 5-аас ОЛОН удаа хариулсан
    for (Card c : cards) {
        if (c.getAskedCount() > 5) {
            System.out.println("Achievement: REPEAT");
            break;
        }
    }

    // CONFIDENT: нэг картад 3-аас ДЭЭШ удаа зөв хариулсан
    for (Card c : cards) {
        if (c.getCorrectCount() >= 3) {
            System.out.println("Achievement: CONFIDENT");
            break;
        }
    }

    // SPEEDRUN: дундаж 5 секундээс доош
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