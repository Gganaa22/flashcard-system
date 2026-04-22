import java.util.*;

public class WorstFirstSorter implements CardOrganizer {

    public List<Card> organize(List<Card> cards) {

        cards.sort((a, b) -> { //Lambda ashiglan sort hiij bn
            int cmp = Integer.compare(b.getWrongCount(), a.getWrongCount());//буруу хариулсан тоогоор ихээс бага руу эрэмбэлнэ.

            if (cmp == 0) {
                return 0; 
            }

            return cmp;
        });

        return cards;
    }
}