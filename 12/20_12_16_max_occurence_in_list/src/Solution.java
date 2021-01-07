import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The solution solves the problem of finding a number in a integer list which occurs more than
 * the other numbers (or one of such numbers). The list must contain at least one element.
 */
public class Solution {

    public int solve(List<Integer> numbers) {
        Map<Integer, Integer> occurrenceByNumber = new HashMap<>();

        for (Integer number : numbers) {
            Integer value = occurrenceByNumber.get(number);
            if (value == null) {
                occurrenceByNumber.put(number, 1);
            } else {
                occurrenceByNumber.put(number, value + 1);
            }

//            occurrenceByNumber.merge(number, 1, (oldValue, newValue) -> oldValue + 1);
        }

        int maxValue = 0;
        int res = 0;

        for (Map.Entry<Integer, Integer> pair : occurrenceByNumber.entrySet()) {
            if (pair.getValue() > maxValue) {
                maxValue = pair.getValue();
                res = pair.getKey();
            }
        }
        return res;
    }
}
