error id: file:///C:/Users/DELL/OneDrive/文档/flashcard/RecentMistakesFirstSorter.java:java/util/List#
file:///C:/Users/DELL/OneDrive/文档/flashcard/RecentMistakesFirstSorter.java
empty definition using pc, found symbol in pc: java/util/List#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 174
uri: file:///C:/Users/DELL/OneDrive/文档/flashcard/RecentMistakesFirstSorter.java
text:
```scala
import java.util.ArrayList;
import java.util.List;

public class RecentMistakesFirstSorter implements CardOrganizer {

    @Override
    public List<Card> organize(List@@<Card> cards) {

        List<Card> wrong = new ArrayList<>();
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

empty definition using pc, found symbol in pc: java/util/List#