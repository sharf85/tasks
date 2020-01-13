package com.telran.collection;

import java.util.Iterator;

public class ArrayQueue<E> implements Queue<E>, Iterable<E> {

    private int size;
    private int first;
    private int capacity;
    private Object[] source;

    ArrayQueue(int capacity) {
        this.capacity = capacity;
        source = new Object[capacity];
    }

    @Override
    public void add(E e) {
        if (size == capacity)
            throw new QueueOverflowException();

        int index = (first + size) % capacity;
        source[index] = e;
        size++;
    }

    @Override
    public E release() {
        if (size == 0)
            throw new EmptyQueueException();
        E value = (E) source[first];
        source[first] = null;
        first = (first + 1) % capacity;
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    class ArrayQueueIterator implements Iterator<E> {

        int currentId = 0;

        @Override
        public boolean hasNext() {
            return currentId < size;
        }

        @Override
        public E next() {
            int index = (currentId + first) % capacity;
            E res = (E) source[index];
            currentId++;
            return res;
        }
    }
}
