error id: file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java:java/lang/Integer#compare().
file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java
empty definition using pc, found symbol in pc: java/lang/Integer#compare().
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 194
uri: file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java
text:
```scala
import java.util.*;

public class WorstFirstSorter implements CardOrganizer {

    public List<Card> organize(List<Card> cards) {

        cards.sort((a, b) ->
            Integer.compare@@(a.getWrongCount(), b.getWrongCount())
        );

        return cards;
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/Integer#compare().