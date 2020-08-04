package com.telran;

public class OurArrayDeque<T> implements OurDeque<T> {

    private int size;
    private int firstEltIndex;
    private final int capacity;

    private final Object[] source;

    public OurArrayDeque(int capacity) {
        this.capacity = capacity;
        source = new Object[capacity];
    }

    @Override
    public void addLast(T elt) {
        if (size == capacity)
            throw new OurDequeOverflowException();

        int nextIndex = (firstEltIndex + size) % capacity;
        source[nextIndex] = elt;
        size++;
    }

    @Override
    public void addFirst(T elt) {

    }

    @Override
    public T removeFirst() {
        if (size == 0)
            throw new OurDequeEmptyException();

        T result = (T) source[firstEltIndex];
        firstEltIndex = (firstEltIndex + 1) % capacity;
        size--;
        return result;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
