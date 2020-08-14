package com.telran;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * An implementation of the List data structure, made via array under the hood.
 * The initial array has length 16. In the case the array is full, a new
 * array with the capacity of 2*<old length> must be created as a new
 * source for the elements.
 *
 * @param <T>
 */
public class OurArrayList<T> implements OurList<T> {

    static final int INITIAL_CAPACITY = 16;
    Object[] source;
    int size;

    public OurArrayList() {
        this.source = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    @Override
    public void add(T elt) {
        if (size == source.length) {
            increaseSource();
        }
        source[size] = elt;
        size++;
    }

    private void increaseSource() {
//        Object[] newSource = new Object[source.length * 2];
//        System.arraycopy(source, 0, newSource, 0, source.length);
//        source = newSource;
        source = Arrays.copyOf(source, source.length * 2);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, T elt) {

    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return (T) source[index];
    }

    @Override
    public boolean contains(T elt) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T elt) {
        return false;
    }

    @Override
    public void sort() {

    }

    @Override
    public void sort(Comparator<T> comparator) {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
