package de.telran;

import java.util.Arrays;
import java.util.Iterator;

public class IncreasingArrayIterator implements Iterator<Integer> {

    private final int[] array;

    public IncreasingArrayIterator(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
        // sort the this.array using a method from Arrays util
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}
