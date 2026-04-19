error id: file:///C:/Users/DELL/OneDrive/文档/flashcard/Card.java:
file:///C:/Users/DELL/OneDrive/文档/flashcard/Card.java
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 263
uri: file:///C:/Users/DELL/OneDrive/文档/flashcard/Card.java
text:
```scala
public class Card {

    private String question;
    private String answer;

    private int correctCount = 0;
    private int wrongCount = 0;

    private int askedCount = 0;

    private boolean lastAnswerWrong = false;private boolean lastAnswerWrong@@ = false;

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
    public void incrementAsked() {
        askedCount++;
    }

    public int getAskedCount() {
        return askedCount;
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 