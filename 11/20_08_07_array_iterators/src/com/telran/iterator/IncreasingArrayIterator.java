package com.telran.iterator;

import java.util.Iterator;

public class IncreasingArrayIterator implements Iterator<Integer> {

    /**
     * a copy of the array which needs to be iterated for.
     */
    Integer[] arrayCopy;

    public IncreasingArrayIterator(Integer[] array) {
        arrayCopy = array;
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
