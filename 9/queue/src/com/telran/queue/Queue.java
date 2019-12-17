package com.telran.queue;

public interface Queue<E> {

    void add(E e);

    E release();

    int size();

    int getCapacity();
}
