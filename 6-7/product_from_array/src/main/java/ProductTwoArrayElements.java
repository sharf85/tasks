import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductTwoArrayElements {
    public boolean isNumberProduct(int[] array, int number) {
        ArrayDeque<Integer> dividerQueue = new ArrayDeque<>();
        for (int member : array) {
            if (number % member == 0)
                dividerQueue.addLast(member);
        }

        while (dividerQueue.size() > 1) {
            int first = dividerQueue.getFirst();
            int last = dividerQueue.getLast();
            int product = first * last;

            if (product == number)
                return true;

            if (product > number) {
                dividerQueue.removeLast();
                continue;
            }

            dividerQueue.removeFirst();
        }

        return false;
    }
}
