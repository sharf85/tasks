package de.telran;

import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO implement iterator. Test
public class CustomArrayDeque<T> implements CustomDeque<T> {

    private T[] source;
    private int size = 0;
    private int firstIndex = 0;

    public CustomArrayDeque() {
        source = (T[]) new Object[8];
    }

    @Override
    public void addFirst(T elt) {
        if (size == source.length)
            increaseCapacity();

        firstIndex = firstIndex - 1;

        if (firstIndex == -1)
            firstIndex = source.length - 1;

        source[firstIndex] = elt;
        size++;
    }

    private void increaseCapacity() {
        T[] newSource = (T[]) new Object[source.length * 2];

        int j = 0;
        for (int i = firstIndex; i < source.length; i++) {
            newSource[j] = source[i];
            j++;
        }

        for (int i = 0; i < firstIndex; i++) {
            newSource[j] = source[i];
            j++;
        }

        firstIndex = 0;
        source = newSource;
    }

    @Override
    public T getFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        return source[firstIndex];
    }

    @Override
    public T removeFirst() {
        T res = getFirst();
        firstIndex = (firstIndex + 1) % source.length;
        size--;
        return res;
    }

    @Override
    public void addLast(T elt) {
        if (size == source.length)
            increaseCapacity();

        int newLastIndex = (firstIndex + size) % source.length;
        source[newLastIndex] = elt;
        size++;
    }

    @Override
    public T getLast() {
        if (size == 0)
            throw new NoSuchElementException();

        int lastIndex = (firstIndex + size - 1) % source.length;
        return source[lastIndex];
    }

    @Override
    public T removeLast() {
        T res = getLast();
        size--;
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
