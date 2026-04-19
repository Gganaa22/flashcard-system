public class Card {

    private String question;
    private String answer;

    private int correctCount = 0;
    private int wrongCount = 0;

    private int askedCount = 0;

    private boolean lastAnswerWrong = false;

    private long totalResponseTime = 0;
    private int roundCount = 0;

    public Card(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void markCorrect() {
        correctCount++;
        lastAnswerWrong = false;
    }

    public void markWrong() {
        wrongCount++;
        lastAnswerWrong = true;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public boolean wasWrongLastTime() {
        return lastAnswerWrong;
    }

    public int getRepeatCount() {
        return correctCount + wrongCount;
    }
    public void incrementAsked() {
        askedCount++;
    }

    public int getAskedCount() {
        return askedCount;
    }
    public void addResponseTime(long ms) {
        totalResponseTime += ms;
        roundCount++;
    }
    public double getAvgResponseTime() {
        return roundCount == 0 ? 0 : (double) totalResponseTime / roundCount;
    }
}