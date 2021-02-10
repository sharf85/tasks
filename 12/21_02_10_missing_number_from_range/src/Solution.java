import java.util.Arrays;

public class Solution {

    /**
     * the method returns the missing number from the range 1 to n
     *
     * @param numbers
     * @return
     */
    public int solve(int[] numbers) {
        int n = numbers.length + 1;

        int completeSum = n * (n + 1) / 2;
        int incompleteSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            incompleteSum += numbers[i];
        }

        return completeSum - incompleteSum;
    }
}
