import java.util.*;

public class WorstFirstSorter implements CardOrganizer {

    public List<Card> organize(List<Card> cards) {

        cards.sort((a, b) -> {
            int cmp = Integer.compare(b.getWrongCount(), a.getWrongCount());

            if (cmp == 0) {
                return 0; 
            }

            return cmp;
        });

        return cards;
    }
}