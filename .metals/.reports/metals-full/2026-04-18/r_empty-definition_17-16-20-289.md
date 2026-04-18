error id: file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java:_empty_/Card#getWrongCount().
file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java
empty definition using pc, found symbol in pc: _empty_/Card#getWrongCount().
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 228
uri: file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java
text:
```scala
import java.util.*;

public class WorstFirstSorter implements CardOrganizer {

    public List<Card> organize(List<Card> cards) {

        cards.sort((a, b) ->
            Integer.compare(a.getWrongCount(), b.getWrongCoun@@t())
        );

        return cards;
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Card#getWrongCount().