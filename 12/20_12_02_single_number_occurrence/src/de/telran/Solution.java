package de.telran;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solve(int[] numbers) {
        Map<Integer, Integer> occurrenceByNumber = new HashMap<>();

        for (int number : numbers) {
//            occurrenceByNumber.compute(number, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
            if (!occurrenceByNumber.containsKey(number)) {
                occurrenceByNumber.put(number, 1);
            } else {
                int oldValue = occurrenceByNumber.get(number);
                occurrenceByNumber.put(number, oldValue + 1);
            }

        }

        for (int number : occurrenceByNumber.keySet()) {
            if (occurrenceByNumber.get(number) % 2 != 0)
                return number;
        }

        return Integer.MIN_VALUE;
    }
//    public int solve(int[] numbers) {
//        int res = 0;
//
//        for (int number : numbers) {
//            res ^= number;
//        }
//        return res;
//    }
}
