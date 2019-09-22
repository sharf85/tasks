import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public int reveal(int[] numbers) {
        Map<Integer, Integer> numberToQty = new HashMap<>();

        for (int number : numbers) {
            Integer qty = numberToQty.get(number);
            if (qty == null)
                numberToQty.put(number, 1);
            else
                numberToQty.put(number, ++qty);
        }

        for (int number : numberToQty.keySet()) {
            if (numberToQty.get(number) % 2 == 1)
                return number;
        }
        return -1;
    }

    public int reveal2(int[] numbers) {
        int res = 0;
        for (int number : numbers) {
            res ^= number;
        }
        return res;
    }
}
