package com.telran.collection;

public class OurArrayList {

    private Object[] source;
    private static final int INITIAL_CAPACITY = 16;
    private int size;

    public OurArrayList() {
        source = new Object[INITIAL_CAPACITY];
    }

    public int size() {
        return size;
    }

    public void add(Object value) {
        if (source.length == size) {
            Object[] newSource = new Object[source.length * 2];
            System.arraycopy(source, 0, newSource, 0, source.length);
            source = newSource;
        }
        source[size] = value;
        size++;
    }

    public Object get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        return source[index];
    }

    public void set(int index, Object value) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        source[index] = value;
    }

    public boolean remove(Object value) {
        for (int i = 0; i < source.length; i++) {
            if (source[i].equals(value)) {
                removeById(i);
                return true;
            }
        }

        return false;
    }

    public Object removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Object result = source[index];

        System.arraycopy(source, index + 1, source, index, source.length - (index + 1));
        size--;
        return result;
    }
}
