package com.telran;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Numbers {

    /**
     * Assume the list is sorted
     *
     * @param N    - integer number
     * @param ints - sorted list of numbers
     * @return true if N is sum of two numbers from ints
     */
    public boolean twoNumbersMakeSum(int N, List<Integer> ints) {
        Deque<Integer> queue = new ArrayDeque<>(ints);//O(n)

        while (queue.size() > 1) {
            if (queue.getFirst() + queue.getLast() > N) {
                queue.removeLast();
            } else if (queue.getFirst() + queue.getLast() < N) {
                queue.removeFirst();
            } else {
                return true;
            }
        }
        return false;
    }
}
