package de.telran;

import java.util.Iterator;

public class OurArrayList<E> implements OurList<E> {

    private static final int INITIAL_CAPACITY = 16;

    private int size;
    private Object[] source;

    public OurArrayList() {
        source = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void add(E element) {
        if (size == source.length)
            increaseCapacity();

        source[size] = element;
        size++;
    }

    // O(n), where n is size
    void increaseCapacity() {
        int newCapacity = source.length * 2;
        Object[] newSource = new Object[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);
        source = newSource;
//        source = Arrays.copyOf(source, source.length * 2);
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) source[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("param pam pam");
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E res = (E) source[index];
        System.arraycopy(source, index + 1, source, index, size - index - 1);
        size--;
        source[size] = null;
        return res;
    }

    @Override
    public boolean remove(E elt) {
        int index = findIndexOfElement(elt);
        if (index == -1)
            return false;

        remove(index);
        return true;
    }

    /**
     * @param elt
     * @return the index of elt if found, -1 otherwise
     */
    private int findIndexOfElement(E elt) {
        // consider the case when the elt is null
        if (elt == null) {
            for (int i = 0; i < size; i++) {
                if (source[i] == null)
                    return i;
            }
            return -1;
        } else {
            for (int i = 0; i < size; i++) {
                if (elt.equals(source[i]))
                    return i;
            }
            return -1;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, E elt) {
        checkIndex(index);
        source[index] = elt;
    }

    @Override
    public boolean contains(E elt) {
        return findIndexOfElement(elt) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new ForwardIterator<>((E[]) source);
        return iterator;
    }

    //TODO complete
    private static class ForwardIterator<T> implements Iterator<T> {

        public ForwardIterator(T[] source) {

        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}

// some changes added
