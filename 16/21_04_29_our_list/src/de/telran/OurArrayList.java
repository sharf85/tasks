package de.telran;

import java.util.Comparator;
import java.util.Iterator;
//TODO implement two methods max() and min() and test them with numbers
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
        System.arraycopy(source, index + 1, source, index, size - index - 1);//O(n)
        size--;
        source[size] = null;
        return res;
    }

    @Override
    public boolean remove(E elt) {
        int index = findIndexOfElement(elt);//O(n) ~ c1*n - operations
        if (index == -1)
            return false;

        remove(index);//O(n) ~ c2*n - operations
        return true;
    }// operations in total ~ (c1+c2)*n => O(n)

    /**
     * @param elt
     * @return the index of elt if found, -1 otherwise
     */
    private int findIndexOfElement(E elt) { // O(n)
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
    public int size() { // O(1)
        return size;
    }

    @Override
    public void set(int index, E elt) { // O(1)
        checkIndex(index); // O(1)
        source[index] = elt;
    }

    @Override
    public boolean contains(E elt) { // O(n)
        return findIndexOfElement(elt) != -1;
    }


    @Override
    public void sort(Comparator<E> comparator) {
        for (int i = 0; i < size; i++) {

            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                E currentMin = (E) source[minIndex];
                if (comparator.compare(currentMin, (E) source[j]) > 0) {
                    minIndex = j;
                }
            }

            Object temp = source[i];
            source[i] = source[minIndex];
            source[minIndex] = temp;
        }
    }

    @Override
    public Iterator<E> backwardIterator() {
        return new BackwardIterator<>((E[]) source, size);
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new ForwardIterator<>((E[]) source, size);
        return iterator;
    }

    private static class ForwardIterator<T> implements Iterator<T> {

        int size;
        T[] source;

        //the field is responsible for the current iterated element
        int currentElementIndex = 0;

        public ForwardIterator(T[] source, int size) {
            this.source = source;
            this.size = size;
        }

        @Override
        public boolean hasNext() {
            return currentElementIndex < size;
        }

        @Override
        public T next() {
            if (currentElementIndex >= size)
                throw new IndexOutOfBoundsException();

            T res = source[currentElementIndex];
            currentElementIndex++;
            return res;
        }
    }

    private static class BackwardIterator<T> implements Iterator<T> {

        T[] source;
        //the field is responsible for the current iterated element
        int currentElementIndex;

        public BackwardIterator(T[] source, int size) {
            this.source = source;
            currentElementIndex = size - 1;
        }

        @Override
        public boolean hasNext() {
            return currentElementIndex >= 0;
        }

        @Override
        public T next() {
            if (currentElementIndex < 0)
                throw new IndexOutOfBoundsException();

            T res = source[currentElementIndex];
            currentElementIndex--;
            return res;
        }
    }
}
