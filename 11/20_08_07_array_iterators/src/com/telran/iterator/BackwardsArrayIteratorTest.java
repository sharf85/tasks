package com.telran.iterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BackwardsArrayIteratorTest {

    @Test
    public void testBackwardsIterator() {
        Integer[] array = new Integer[]{3, -5, 1};
        List<Integer> expected = Arrays.asList(1, -5, 3);
        List<Integer> afterIteration = new ArrayList<>();

        BackwardsArrayIterator<Integer> it = new BackwardsArrayIterator<>(array);
        while (it.hasNext()) {
            int num = it.next();
            afterIteration.add(num);
        }

        assertEquals(expected, afterIteration);
    }
}
