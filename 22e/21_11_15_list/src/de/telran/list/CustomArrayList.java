package de.telran.list;

import de.telran.CustomOutOfBoundsException;

public class CustomArrayList<T> implements CustomList<T> {

    private static final int INITIAL_CAPACITY = 8;
    private T[] source;
    private int size;

    public CustomArrayList() {
        source = (T[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public void set(int index, T value) {
        if (index < 0 || index >= size)
            throw new CustomOutOfBoundsException();

        source[index] = value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new CustomOutOfBoundsException();

        return source[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (source[i].equals(value))
                return true;
        }

        return false;
    }

    @Override
    // TODO fix
    public T removeById(int index) {
        if (index < 0 || index >= size)
            throw new CustomOutOfBoundsException();

        T res = source[index];
        for (int i = index + 1; i < size; i++) {
            source[i - 1] = source[i];
        }
        size--;
        return res;
    }

    @Override
    // TODO implement
    public boolean removeByValue(T value) {
        return false;
    }

    @Override
    public void add(T value) {
        if (size == source.length)
            increaseCapacity();

        source[size++] = value;
    }

    private void increaseCapacity() {
        T[] newSource = (T[]) new Object[source.length * 2];

        for (int i = 0; i < source.length; i++) {
            newSource[i] = source[i];
        }

        source = newSource;
    }

    @Override
    public void insert(int index, T value) {
        if (index < 0 || index > size)
            throw new CustomOutOfBoundsException();

        if (size == source.length)
            increaseCapacity();

        for (int i = size; i > index; i--) {
            source[i] = source[i - 1];
        }

        source[index] = value;
        size++;
    }

    @Override
    public void println() {
        for (int i = 0; i < size; i++) {
            System.out.print(source[i] + " ");
        }
        System.out.println();
    }
}
