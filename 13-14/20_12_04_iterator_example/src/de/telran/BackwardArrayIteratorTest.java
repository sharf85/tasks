package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BackwardArrayIteratorTest {
    @Test
    public void testIterator_emptyArray_nothing() {
        int[] array = {};

        int[] res = iterateToArray(array);
        assertArrayEquals(new int[]{}, res);
    }

    @Test
    public void testIterator_oneElement() {
        int[] array = {5};

        int[] res = iterateToArray(array);
        assertArrayEquals(new int[]{5}, res);
    }

    @Test
    public void testIterator_severalElements() {
        int[] array = {10, -8, 0, 15};

        int[] res = iterateToArray(array);
        assertArrayEquals(new int[]{15, 0, -8, 10}, res);
        assertArrayEquals(new int[]{10, -8, 0, 15}, array);
    }

    private int[] iterateToArray(int[] array) {
        int[] res = new int[array.length];

        Iterator<Integer> iterator = new BackwardArrayIterator(array);
        int i = 0;
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }

        return res;
    }

}
