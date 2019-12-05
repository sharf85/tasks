package com.telran.collection;

public interface OurList {

    void append(Object o);

    Object get(int index);

    void set(Object o, int index);

    int size();

    boolean contains();

    boolean remove(Object o);

    Object removeById(int index);
}
