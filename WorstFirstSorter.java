import java.util.*;

public class WorstFirstSorter implements CardOrganizer {

    public List<Card> organize(List<Card> cards) {

        cards.sort((a, b) ->
            Integer.compare(a.getWrongCount(), b.getWrongCount())
        );

        return cards;
    }
}