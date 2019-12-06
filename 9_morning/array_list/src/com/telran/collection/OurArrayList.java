package com.telran.collection;

public class OurArrayList extends List {

    private Object[] source;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;

    public OurArrayList() {
        source = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public void append(Object o) {
        if (size == source.length) {
            Object[] newSource = new Object[size * 2];
            System.arraycopy(source, 0, newSource, 0, source.length);
            source = newSource;
        }
        source[size] = o;
        size++;
    }

    public Object get(int index) {
        return source[index];
    }

    public void set(Object o, int index) {
        source[index] = o;
    }

    public Object removeById(int index) {
        Object o = source[index];
        System.arraycopy(source, index + 1, source, index, size - index);
        size--;
        return o;
    }

    public boolean remove(Object o) {
        return false;
    }
}
