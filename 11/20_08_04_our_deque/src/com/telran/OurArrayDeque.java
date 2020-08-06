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
        if (size == capacity)
            throw new OurDequeOverflowException();

        if (firstEltIndex > 0)
            firstEltIndex--;
        else
            firstEltIndex = capacity - 1;

        source[firstEltIndex] = elt;
        size++;
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
        if (size == 0)
            throw new OurDequeEmptyException();

        int lastEltIndex = (firstEltIndex + size - 1) % capacity;
        size--;
        return (T) source[lastEltIndex];
    }

    @Override
    public T getFirst() {
        if (size == 0)
            throw new OurDequeEmptyException();

        return (T) source[firstEltIndex];
    }

    @Override
    public T getLast() {
        if (size == 0)
            throw new OurDequeEmptyException();

        int lastEltIndex = (firstEltIndex + size - 1) % capacity;
        return (T) source[lastEltIndex];
    }

    @Override
    public int size() {
        return size;
    }
}
