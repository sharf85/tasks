package de.telran;

import java.util.Iterator;

public class ForwardArrayIterator implements Iterator<Integer> {

    private final int[] array;
    private int currentIndex = 0;

    public ForwardArrayIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.length;
    }

    @Override
    public Integer next() {
        int res = array[currentIndex];
        currentIndex++;
        return res;
    }
}
