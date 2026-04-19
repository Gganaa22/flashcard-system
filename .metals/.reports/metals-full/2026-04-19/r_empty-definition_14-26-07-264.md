error id: file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java:java/lang/Integer#
file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java
empty definition using pc, found symbol in pc: java/lang/Integer#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 197
uri: file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java
text:
```scala
import java.util.*;

public class WorstFirstSorter implements CardOrganizer {

    public List<Card> organize(List<Card> cards) {

        cards.sort((a, b) -> {
            int cmp = Intege@@r.compare(b.getWrongCount(), a.getWrongCount());

            if (cmp == 0) {
                return 0; // 🔥 stable order хадгална
            }

            return cmp;
        });

        return cards;
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/Integer#