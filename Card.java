public class Card {

    private String question;
    private String answer;

    private int correctCount = 0;
    private int wrongCount = 0;

    private boolean wrongLastTime = false;

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
        wrongLastTime = false;
    }

    public void markWrong() {
        wrongCount++;
        wrongLastTime = true;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public boolean wasWrongLastTime() {
        return wrongLastTime;
    }

    public int getRepeatCount() {
        return correctCount + wrongCount;
    }
}