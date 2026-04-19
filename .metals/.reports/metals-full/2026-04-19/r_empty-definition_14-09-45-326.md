error id: file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java:java/util/List#sort().
file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java
empty definition using pc, found symbol in pc: java/util/List#sort().
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 157
uri: file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java
text:
```scala
import java.util.*;


public class WorstFirstSorter implements CardOrganizer {

    public List<Card> organize(List<Card> cards) {

        cards.sort@@((a, b) ->
            Integer.compare(b.getWrongCount(), a.getWrongCount())
        );

        return cards;
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/util/List#sort().