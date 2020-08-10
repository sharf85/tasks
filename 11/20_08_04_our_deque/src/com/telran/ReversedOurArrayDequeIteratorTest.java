package com.telran;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReversedOurArrayDequeIteratorTest {

    OurArrayDeque<Integer> deque = new OurArrayDeque<>(16);

    @Test
    public void testIterator_mixedDeque_reversedOrder() {
        deque.addLast(3);
        deque.addFirst(8);
        deque.addFirst(10);
        deque.addFirst(-3);
        deque.addLast(5);
        deque.addFirst(-5);

        Iterator<Integer> it = new ReversedOurArrayDequeIterator<>(deque);

        List<Integer> result = new ArrayList<>();
        while (it.hasNext()) {
            int current = it.next();
            result.add(current);
        }

        List<Integer> expected = Arrays.asList(5, 3, 8, 10, -3, -5);
        assertEquals(expected, result);
    }

    @Test
    public void testIterator_noElements_noIterations() {
        Iterator<Integer> it = new ReversedOurArrayDequeIterator<>(deque);
        assertFalse(it.hasNext());
    }

}
