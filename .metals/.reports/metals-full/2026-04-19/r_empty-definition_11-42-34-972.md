error id: file:///C:/Users/DELL/OneDrive/文档/flashcard/Card.java:java/lang/String#
file:///C:/Users/DELL/OneDrive/文档/flashcard/Card.java
empty definition using pc, found symbol in pc: java/lang/String#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 235
uri: file:///C:/Users/DELL/OneDrive/文档/flashcard/Card.java
text:
```scala
public class Card {

    private String question;
    private String answer;

    private int correctCount = 0;
    private int wrongCount = 0;

    private boolean wrongLastTime = false;

    public Card(String question, Str@@ing answer) {
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
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/String#