package com.telran;

import java.util.LinkedList;
import java.util.List;

public class TwoDivisors {

    public boolean isDivisors(List<Integer> nums, int N) {
        LinkedList<Integer> buffer = new LinkedList<>(nums);

        while (buffer.size() >= 2) {
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
