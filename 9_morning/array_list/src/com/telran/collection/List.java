package com.telran.collection;

public interface List {

    int size();

    void append(Object o);

    Object get(int index);

    void set(Object o, int index);

    Object removeById(int index);

    boolean remove(Object o);

    boolean contains(Object o);

}
