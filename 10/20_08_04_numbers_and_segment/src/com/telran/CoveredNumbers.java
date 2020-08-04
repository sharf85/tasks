package com.telran;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CoveredNumbers {

    /**
     * The method counts the max number of points covered by a segment of the length l
     *
     * @param numbers sorted list
     * @param l       positive double number
     * @return max covered points
     */
    public int getMaxCoveredNumbers(List<Double> numbers, double l) {
        int res = 0;
        Deque<Double> segment = new ArrayDeque<>();

        for (double number : numbers) {
            double left = number - l;
            segment.addLast(number);

            while (segment.getFirst() < left)
                segment.removeFirst();

            if (segment.size() > res)
                res = segment.size();
        }
        return res;
    }
}
