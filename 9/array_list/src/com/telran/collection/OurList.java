package com.telran.collection;

public interface OurList<E> {

    void append(E o);

    E get(int index);

    void set(E o, int index);

    int size();

    boolean contains(E o);

    boolean remove(E o);

    E removeById(int index);
}
