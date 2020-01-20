package com.telran.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class OurArrayListRandomIterator<E> implements Iterator<E> {

    private List<E> temp;

    public OurArrayListRandomIterator(OurArrayList<E> list) {
        temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            temp.add(list.get(i));
        }

        Collections.shuffle(temp);
    }

    private int currentId = 0;

    @Override
    public boolean hasNext() {
        return currentId < temp.size();
    }

    @Override
    public E next() {
        return temp.get(currentId++);
    }
}
