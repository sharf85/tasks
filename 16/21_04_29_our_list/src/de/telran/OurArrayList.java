package de.telran;

import java.util.Comparator;
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
//        if(num1<num2) - old style writing for sorting an array with numbers
//        if(comparator.compare(o1, o2)<0) - new style or sorting out source array of objects
        //TODO implement any kind of sort using comparator instead of the operators '>' and '<'
    }


    public Iterator<E> backwardIterator() {
        // TODO the method should return an instance of Iterator which iterates over our collection
        // conversely.
        return null;
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
            T res = source[currentElementIndex];
            currentElementIndex++;
            return res;
        }
    }
}
