package com.telran.queue;

public interface Queue<E> extends Iterable<E> {

    void add(E e);

    E release();

    int size();

    int getCapacity();
}
