import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RecentMistakesFirstSorter implements CardOrganizer {

    @Override
    public List<Card> organize(List<Card> cards) {

        List<Card> wrong = new ArrayList<>();
        List<Card> correct = new ArrayList<>();

        for (Card c : cards) {
            if (c.wasWrongLastTime()) {
                wrong.add(c);
            } else {
                correct.add(c);
            }
        }

        wrong.sort(Comparator.comparingInt(Card::getWrongOrder).reversed()); 

        wrong.addAll(correct);
        return wrong;
    }
}