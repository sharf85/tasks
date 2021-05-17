package de.telran;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OurArrayDeque<E> implements OurDeque<E> {

    private static final int INITIAL_CAPACITY = 16;

    E[] source;
    int size;

    // the field points out to the first element in the data structure.
    int firstIndex;

    OurArrayDeque() {
        source = (E[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public void addLast(E elt) {
        if (size == source.length)
            increaseSource();

        int newLastIndex = (firstIndex + size) % source.length;
        source[newLastIndex] = elt;
        size++;
    }

    private void increaseSource() {
        E[] newSource = (E[]) new Object[source.length * 2];

//        int i = 0;
//        for (E elt : this) {
//            newSource[i++] = elt;
//        }
//
        System.arraycopy(source, firstIndex, newSource, 0, source.length - firstIndex);
        System.arraycopy(source, 0, newSource, source.length - firstIndex, firstIndex);

        firstIndex = 0;
        this.source = newSource;
    }

    //TODO complete
    @Override
    public void addFirst(E elt) {

    }

    @Override
    public E removeFirst() {
        if (size == 0)
            throw new NoSuchElementException();

        E res = source[firstIndex];
        size--;
        firstIndex = (firstIndex + 1) % source.length;

        // alternative
//        if (firstIndex == source.length - 1)
//            firstIndex = 0;
//        else
//            firstIndex++;
        return res;
    }

    //TODO complete
    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E getFirst() {
        if (size == 0)
            throw new NoSuchElementException();

        return source[firstIndex];
    }

    @Override
    public E getLast() {
        if (size == 0)
            throw new NoSuchElementException();

        int lastIndex = (firstIndex + size - 1) % source.length;
        return source[lastIndex];
    }

    @Override
    public int size() {
        return size;
    }

    //TODO the assignment of higher complexity
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
