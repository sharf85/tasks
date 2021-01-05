package de.telran;

import java.util.Comparator;
import java.util.Iterator;

public class OurArrayList<Type> implements OurList<Type> {

    private static final int INITIAL_CAPACITY = 16;

    private int size;
    private Object[] source;

    public OurArrayList() {
        source = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void addLast(Type element) {
        if (size == source.length)
            increaseCapacity();

//        source[size++] = element;
        source[size] = element;
        size++;
    }

    // O(n), where n is size
    void increaseCapacity() {
        int newCapacity = source.length * 2;
        Object[] newSource = new Object[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);
        source = newSource;
    }

    @Override
    // O(1) - the number of operations is never dependant on the number of elements in the list
    public Type get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        return (Type) source[index];
    }

    @Override
    // O(1) - the number of operations is never dependant on the number of elements in the list
    public void set(int index, Type value) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        source[index] = value;
    }

    @Override
    // O(n), where n is size
    public Type removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Type res = (Type) source[index];
        System.arraycopy(source, index + 1, source, index, size - index - 1);
        source[size - 1] = null;
        size--;
        return res;
    }

    @Override
    // O(1)
    public int size() {
        return size;
    }

    @Override
    // O(1)
    public void clear() {
        source = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    // O(n) - to find the needle. And O(n) - to remove it by its index
    // total number of operations is O(n)
    public boolean remove(Type obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (source[i] == null) {
                    removeById(i);
                    return true;
                }
            }
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (obj.equals(source[i])) {
                removeById(i);
                return true;
            }
        }
        return false;
    }

    @Override
    // O(n) - to find the needle.
    public boolean contains(Type obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (source[i] == null)
                    return true;
            }
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (obj.equals(source[i]))
                return true;
        }
        return false;
    }

    @Override
    // O(n) is the complexity of using the iterator
    public Iterator<Type> forwardIterator() {
        Iterator<Type> iterator = new ForwardIterator();
        return iterator;
    }

    @Override
    public Iterator<Type> backwardIterator() {
        Iterator<Type> iterator = new BackwardIterator<>((Type[]) source, size);
        return iterator;
    }

    @Override
    public void sort(Comparator<Type> comparator) {

    }

    @Override
    public Iterator<Type> iterator() {
        return forwardIterator();
    }

    private class ForwardIterator implements Iterator<Type> {

        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Type next() {
            if (currentIndex >= size)
                throw new IndexOutOfBoundsException();

            Type res = (Type) source[currentIndex];
            currentIndex++;
            return res;
        }
    }

    private static class BackwardIterator<O> implements Iterator<O> {
        int currentIndex;
        O[] source;

        public BackwardIterator(O[] source, int size) {
            this.source = source;
            currentIndex = size - 1;
        }

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public O next() {
            if (currentIndex < 0)
                throw new IndexOutOfBoundsException();

            O res = source[currentIndex];
            currentIndex--;
            return res;
        }
    }
}

