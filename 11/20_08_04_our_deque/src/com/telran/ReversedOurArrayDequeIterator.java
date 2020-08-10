package com.telran;

import java.util.Iterator;

public class ReversedOurArrayDequeIterator<T> implements Iterator<T> {

    OurArrayDeque<T> toIterate;

    /**
     * can be (size-1) down to 0
     */
    int currentOrderIndex;

    public ReversedOurArrayDequeIterator(OurArrayDeque<T> toIterate) {
        this.toIterate = toIterate;
        currentOrderIndex = toIterate.size - 1;
    }

    @Override
    public boolean hasNext() {
        return currentOrderIndex >= 0;
    }

    @Override
    public T next() {
        int currentSourceIndex = (toIterate.firstEltIndex + currentOrderIndex) % toIterate.capacity;
        currentOrderIndex--;
        return (T) toIterate.source[currentSourceIndex];
    }
}
