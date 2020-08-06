package com.telran;

import java.util.Iterator;

public class ReversedOurArrayDequeIterator<T> implements Iterator<T> {

    OurArrayDeque<T> toIterate;

    public ReversedOurArrayDequeIterator(OurArrayDeque<T> toIterate) {
        this.toIterate = toIterate;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
