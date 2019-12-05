package com.telran.collection;

public class OurArrayList extends List {

    private Object[] source;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;

    OurArrayList() {
        source = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public void append() {

    }

    public Object get(int index) {
        return null;
    }

    public void set(Object o, int index) {

    }

    public Object removeById(int index) {
        return null;
    }

    public boolean remove(Object o) {
        return false;
    }
}
