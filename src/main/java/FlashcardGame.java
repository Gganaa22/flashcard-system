import java.util.*;
import java.io.*;

public class FlashcardGame {

    private List<Card> cards = new ArrayList<>();
    private String file;
    private String order = "none";
    private int repetitions = 1;
    private boolean invert = false;

    private int wrongCounter = 0;

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
        List<Card> remaining = new ArrayList<>(); //dahin asuuh shaardlagatai card uud
        for (Card c : cards) {
            if (correctStreak.get(c) < repetitions) {
                remaining.add(c);
            }
        }

        if (remaining.isEmpty()) break;

        remaining = organizer.organize(remaining);



        
        for (Card c : new ArrayList<>(remaining)) {
            if (correctStreak.get(c) >= repetitions) continue;

            String q       = invert ? c.getAnswer()   : c.getQuestion();//invert=true bol answer → question
            String correct = invert ? c.getQuestion()  : c.getAnswer();//zov hariug todrhoil bn

            System.out.println("\nQ: " + q);
            System.out.print("Your answer: ");
            long start = System.currentTimeMillis();
            String ans = sc.nextLine().trim();//hereglegciin input.
            long elapsed = System.currentTimeMillis() - start;
            c.addResponseTime(elapsed);

            
            if (ans.equalsIgnoreCase("q") || ans.equalsIgnoreCase("quit")) {
                System.out.println("Programm zogsloo.");
                sc.close();
                showAchievements();
                return;
                }
            
            //Хариу шалгах
            if (ans.equalsIgnoreCase(correct)) {
                System.out.println(" Correct!");
                c.markCorrect();
                correctStreak.put(c, correctStreak.get(c) + 1);
            } else {
                System.out.println(" Wrong! (Correct: " + correct + ")");
                c.markWrong(++wrongCounter); 
                 
            }
            c.incrementAsked();
        }
        
        System.out.println("\n------------------");
        
    }

    sc.close();
    showAchievements();
    }

//card erembeleh strategy ee songono 
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

    private void load() { //flashcard file iig unshina
        try (Scanner sc = new Scanner(new File(file))) {//file neene
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
        System.out.println("Achievement: CORRECT");
    }

    
    for (Card c : cards) {
        if (c.getAskedCount() > 5) {
            System.out.println("Achievement: REPEAT");
            break;
        }
    }

    
    for (Card c : cards) {
        if (c.getCorrectCount() >= 3) {
            System.out.println("Achievement: CONFIDENT");
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