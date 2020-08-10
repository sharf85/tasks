package com.telran.iterator;

import java.util.Iterator;

public class ForwardArrayIterator<T> implements Iterator<T> {
    T[] array;
    int currentIndex;

    ForwardArrayIterator(T[] array) {
        this.array = array;
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.length;
    }

    @Override
    public T next() {
        return array[currentIndex++];
    }

}
