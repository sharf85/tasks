package de.telran;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

// TODO Complete. Use TreeMap as a source
public class TreeSet<T> implements Set<T> {

    Comparator<T> comparator;
    private final Object o = new Object();

    public TreeSet(Comparator<T> comparator) {
        this.comparator = comparator;
        TreeMap<T, Object> source = new TreeMap<>(comparator);
    }

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
    public void addAll(Set<T> another) {

    }

    @Override
    public void removeAll(Set<T> another) {

    }

    @Override
    public void retainAll(Set<T> another) {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
