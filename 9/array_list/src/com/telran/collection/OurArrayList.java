package com.telran.collection;

public class OurArrayList {

    Object[] source;
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
        return null;
    }

    public void set(int index, Object value) {

    }

    public boolean remove(Object value) {
        return false;
    }

    public Object removeById(int index) {
        return null;
    }
}
