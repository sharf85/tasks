package de.telran;

import java.util.Iterator;

//TODO complete
public class BackwardArrayIterator implements Iterator<Integer> {

    private final int[] array;
    private int currentIndex;

    public BackwardArrayIterator(int[] array) {
        this.array = array;
        currentIndex = array.length - 1;
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
