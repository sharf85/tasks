package com.telran.collection;

import java.util.Iterator;

public class OurArrayListIterator<E> implements Iterator<E> {

    private OurArrayList<E> list;
    private int currentId = 0;

    public OurArrayListIterator(OurArrayList<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return currentId < list.size();
    }

    @Override
    public E next() {
        return list.get(currentId++);
    }
}
