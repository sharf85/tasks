package de.telran;

import de.telran.map.OurHashMap;

import java.util.Iterator;

public class OurHashSet<T> implements OurSet<T> {

    private OurHashMap<T, Object> source;

    private final Object stubValue = new Object();

    @Override
    public boolean add(T elt) {
        return false;
    }

    @Override
    public boolean remove(T elt) {
        return false;
    }

    @Override
    public boolean contains(T elt) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void addAll(OurSet<T> another) {

    }

    @Override
    public void retainAll(OurSet<T> another) {

    }

    @Override
    public void removeAll(OurSet<T> another) {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
