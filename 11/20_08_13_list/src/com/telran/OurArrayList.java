package com.telran;

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

    Object[] source;

    @Override
    public void add(T elt) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void set(int index, T elt) {

    }

    @Override
    public T get(int index) {
        return null;
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
    public Iterator<T> iterator() {
        return null;
    }
}
