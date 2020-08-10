package com.telran;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayNegativesToPositivesIteratorTest {

    @Test
    public void testIterator_mixedArray_correctOrder() {
        int[] arrayToIterate = {10, -3, 5, -5, 0, 7, -1, 4};
        List<Integer> expected = Arrays.asList(-3, -5, -1, 10, 5, 0, 7, 4);

        List<Integer> afterIterations = new ArrayList<>();

        Iterator<Integer> it = new ArrayNegativesToPositivesIterator(arrayToIterate);

        while (it.hasNext()) {
            int num = it.next();
            afterIterations.add(num);
        }

        assertEquals(expected, afterIterations);
    }
}
