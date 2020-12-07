package de.telran;

import java.util.Arrays;
import java.util.Iterator;

public class IncreasingArrayIterator implements Iterator<Integer> {

    private int[] source;
    private int currentIndex;

    public IncreasingArrayIterator(int[] arrayToIterate) {
        this.source = Arrays.copyOf(arrayToIterate, arrayToIterate.length);
        Arrays.sort(this.source);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < source.length;
    }

    @Override
    public Integer next() {
        return source[currentIndex++];
    }
}
