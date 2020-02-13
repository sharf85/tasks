package com.telran.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OurHashSet<E> extends OurAbstractSet<E> {

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
        return source.containsKey(elt);
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public Iterator<E> iterator() {
        return source.keySet().iterator();
    }
}
