error id: file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java:_empty_/Card#getQuestion().
file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java
empty definition using pc, found symbol in pc: _empty_/Card#getQuestion().
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 338
uri: file:///C:/Users/DELL/OneDrive/文档/flashcard/WorstFirstSorter.java
text:
```scala
import java.util.*;



public class WorstFirstSorter implements CardOrganizer {

    public List<Card> organize(List<Card> cards) {

        cards.sort((a, b) -> {
            int cmp = Integer.compare(b.getWrongCount(), a.getWrongCount());
            if (cmp == 0) {
                return a.getQuestion().compareTo(b.getQues@@tion());
            }
            return cmp;
        });

        return cards;
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Card#getQuestion().