package de.telran.list;

import de.telran.CustomOutOfBoundsException;

import java.util.Iterator;

public class AdvancedArrayList<T> implements CustomList<T> {
    private T[] source;

    public AdvancedArrayList(int initialSize) {
        source = (T[]) new Object[initialSize];
    }

    @Override
    public void set(int index, T value) {
        if (index < 0 || index >= source.length)
            throw new CustomOutOfBoundsException();

        source[index] = value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= source.length)
            throw new CustomOutOfBoundsException();
        return source[index];
    }

    @Override
    public int size() {
        return source.length;
    }

    @Override
    public void insert(int index, T elt) {
        if (index < 0 || index > source.length)
            throw new CustomOutOfBoundsException();

        T[] newSource = (T[]) new Object[source.length + 1];

        for (int i = 0; i < index; i++) {
            newSource[i] = source[i];
        }
        newSource[index] = elt;

        for (int i = index + 1; i < newSource.length; i++) {
            newSource[i] = source[i - 1];
        }

        source = newSource;
    }

    @Override
    public boolean contains(T elt) {
        for (int i = 0; i < source.length; i++) {
            if (source[i].equals(elt))
                return true;
        }

        return false;
    }

    @Override
    public T removeById(int index) {
        if (index < 0 || index >= source.length)
            throw new CustomOutOfBoundsException();

        T[] newSource = (T[]) new Object[source.length - 1];

        T res = source[index];
        for (int i = 0; i < index; i++) {
            newSource[i] = source[i];
        }

        for (int i = index + 1; i < source.length; i++) {
            newSource[i - 1] = source[i];
        }

        source = newSource;
        return res;
    }

    @Override
    public boolean removeByValue(T value) {
        for (int i = 0; i < source.length; i++) {
            if (source[i].equals(value)) {
                removeById(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T value) {
        insert(source.length, value);
    }

    @Override
    public void println() {
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        int currentId = 0;

        @Override
        public boolean hasNext() {
            return currentId < source.length;
        }

        @Override
        public T next() {
            T res = source[currentId];
            currentId++;
            return res;
        }
    }
}
