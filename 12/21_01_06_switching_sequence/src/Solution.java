import java.util.List;

public class Solution {

    public boolean isSwitching(int[] array) {
        if (array.length < 3)
            return true;

        for (int i = 2; i < array.length; i++) {
            if (array[i] != array[i - 2])
                return false;
        }

        return true;
    }

    public boolean isSwitching(List<Integer> list) {
        int[] array = list.stream()
                .mapToInt(value -> value)
                .toArray();

        return isSwitching(array);
    }

}
