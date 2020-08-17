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
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        source[index] = elt;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return (T) source[index];
    }

    @Override
    public boolean contains(T elt) {
        int index = getIndexOf(elt);
        return index != -1;
    }

    /**
     * searches for the index of the elt in this list
     *
     * @param elt to find
     * @return actual index or -1 if not found
     */
    private int getIndexOf(T elt) {
        for (int i = 0; i < size; i++) {
            if (elt.equals(source[i]))
                return i;
        }
        return -1;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        T elt = (T) source[index];

        System.arraycopy(source, index + 1, source, index, size - index - 1);
        size--;
        return elt;
    }

    @Override
    public boolean remove(T elt) {
        int index = getIndexOf(elt);

        if (index == -1)
            return false;

        remove(index);
        return true;
    }

    @Override
    public void sort() {
        Arrays.sort(source, 0, size);
    }

    @Override
    public void sort(Comparator<T> comparator) {
        Arrays.sort((T[]) source, 0, size, comparator);
    }

    @Override
    public Iterator<T> iterator() {
//        return new Iterator<>() {
//
//            int currentIndex = 0;
//
//            @Override
//            public boolean hasNext() {
//                return currentIndex < size;
//            }
//
//            @Override
//            public T next() {
//                return (T) source[currentIndex++];
//            }
//        };
        return new DefaultIterator();
    }

    class DefaultIterator implements Iterator<T> {

        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            return (T) source[currentIndex++];
        }
    }

}
