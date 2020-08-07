package com.telran.iterator;

import java.util.Iterator;

public class BackwardsArrayIterator<T> implements Iterator<T> {
    T[] array;
    int currentIndex;

    BackwardsArrayIterator(T[] array) {
        this.array = array;
        currentIndex = array.length - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public T next() {
        T res = array[currentIndex];
        currentIndex--;
        return res;
    }
}
