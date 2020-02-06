package com.telran.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OurHashSet<E> implements OurSet<E> {

    private static final Object INSTANCE = new Object();

    private Map<E, Object> source;

    public OurHashSet() {
        source = new HashMap<>();
    }

    @Override
    public boolean add(E elt) {
        return source.put(elt, INSTANCE) == null;
    }

    @Override
    public boolean remove(E elt) {
        return source.remove(elt) != null;
    }

    @Override
    public boolean contains(E elt) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean addAll(OurSet<E> other) {

        boolean res = false;
        for (E elt : other) {
            res |= this.add(elt);
        }

        return res;
    }

    @Override
    public boolean removeAll(OurSet<E> other) {
        return false;
    }

    @Override
    public boolean retainAll(OurSet<E> other) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
