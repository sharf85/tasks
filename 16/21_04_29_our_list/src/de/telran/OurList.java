package de.telran;

import java.util.Comparator;
import java.util.Iterator;

public interface OurList<E> extends Iterable<E> {

    /**
     * the method returns the element by the index
     *
     * @param index
     * @return the element if the index is between 0 and size - 1
     * @throws IndexOutOfBoundsException otherwise
     */
    E get(int index);

    /**
     * adds en element to the list
     *
     * @param elt
     */
    void add(E elt);

    /**
     * removes the element by the index from the collection
     *
     * @param index
     * @return element to be removed
     * @throws IndexOutOfBoundsException in the index is incorrect
     */
    E remove(int index);

    /**
     * removes the element if found in the collection
     *
     * @param elt to remove
     * @return true if found and removed, false otherwise
     */
    boolean remove(E elt);

    /**
     * @return size of the collection
     */
    int size();

    /**
     * puts the element by the index
     *
     * @param index
     * @param elt
     * @throws IndexOutOfBoundsException in the index is incorrect
     */
    void set(int index, E elt);

    /**
     * @param elt
     * @return true if the element is found in the collection
     */
    boolean contains(E elt);

    /**
     * The method must sort this list according to the comparator rule.
     *
     * @param comparator
     */
    void sort(Comparator<E> comparator);

    E max(Comparator<E> comparator);

    E min(Comparator<E> comparator);

    /**
     * The method returns an iterator which iterates in the backward order.
     * The iterator must throw IndexOutOfBoundsException if the it.next() is invoked and no elements
     * remain to iterate over.
     *
     * @return iterator in backward order
     */
    Iterator<E> backwardIterator();

    /**
     * The iterator must throw IndexOutOfBoundsException if the it.next() is invoked and no elements
     * remain to iterate over.
     *
     * @return iterator in regular order
     */
    @Override
    Iterator<E> iterator();
}
