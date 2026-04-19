error id: file:///C:/Users/DELL/OneDrive/文档/flashcard/RecentMistakesFirstSorter.java:local1
file:///C:/Users/DELL/OneDrive/文档/flashcard/RecentMistakesFirstSorter.java
empty definition using pc, found symbol in pc: 
found definition using semanticdb; symbol local1
empty definition using fallback
non-local guesses:

offset: 217
uri: file:///C:/Users/DELL/OneDrive/文档/flashcard/RecentMistakesFirstSorter.java
text:
```scala
import java.util.ArrayList;
import java.util.List;

public class RecentMistakesFirstSorter implements CardOrganizer {

    @Override
    public List<Card> organize(List<Card> cards) {

        List<Card> wrong@@ = new ArrayList<>();
        List<Card> correct = new ArrayList<>();

        for (Card c : cards) {
            if (c.wasWrongLastTime()) {
                wrong.add(c);
            } else {
                correct.add(c);
            }
        }

        wrong.addAll(correct);
        return wrong;
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 