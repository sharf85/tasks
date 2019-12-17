package com.telran.queue;

public class ArrayQueue<E> implements Queue<E> {

    private int size;
    private int first;
    private Object[] source;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        source = new Object[capacity];
    }

    @Override
    public void add(E e) {
        if (size == capacity)
            throw new FullQueueException();

        int index = (first + size) % capacity;
        source[index] = e;
        size++;
    }

    @Override
    public E release() {
        if (size == 0)
            throw new NoElementsException();
        E value = (E) source[first];
        source[first] = null;
        first = (first + 1) % capacity;
        size--;
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
