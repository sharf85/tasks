package de.telran;

public class OurFixedArrayDeque<T> implements OurDeque<T> {

    private int firstEltId;
    private int size;
    private Object[] source;
    private int capacity;

    public OurFixedArrayDeque(int initialCapacity) {
        this.source = new Object[initialCapacity];
        this.capacity = source.length;
    }

    @Override
    public void addFirst(T elt) {

    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T removeFirst() {
        if (size == 0)
            throw new EmptyDequeException();

        T res = (T) source[firstEltId];
        source[firstEltId] = null;
        firstEltId = (firstEltId + 1) % capacity;
        return res;
    }

    @Override
    public void addLast(T elt) {
        if (size == source.length)
            throw new DequeOverflowException();

        int index = (firstEltId + size) % capacity;
        source[index] = elt;
        size++;
    }

    @Override
    public T getLast() {
        int lastIndex = (firstEltId + size - 1) % capacity;
        return (T) source[lastIndex];
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
