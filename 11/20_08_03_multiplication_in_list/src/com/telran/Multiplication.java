package com.telran;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Multiplication {

    /**
     * The method determines whether the N number can be
     * represented as a multiplication of any two numbers from the
     * list numbers.
     *
     * @param numbers sorted list of positive int numbers
     * @param N       positive int value
     * @return found or not the two numbers
     */
    public boolean isMultiplied(List<Integer> numbers, int N) {
        Deque<Integer> buffer = new ArrayDeque<>(numbers);

        while (buffer.size() > 1) {
            int mult = buffer.getFirst() * buffer.getLast();
            if (mult < N) {
                buffer.removeFirst();
            } else if (mult > N) {
                buffer.removeLast();
            } else {
                return true;
            }
        }

        return false;
    }
}
