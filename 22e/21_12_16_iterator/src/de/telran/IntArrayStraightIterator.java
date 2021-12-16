package de.telran;

import java.util.Iterator;

//{10, 7, 17, 25}
public class IntArrayStraightIterator implements Iterator<Integer> {

    private final int[] array;
    int currentId = 0;

    public IntArrayStraightIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return currentId < array.length;
    }

    @Override
    public Integer next() {
        int res = array[currentId];
        currentId++;
        return res;
    }
}
