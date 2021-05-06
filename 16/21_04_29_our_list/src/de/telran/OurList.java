package de.telran;

import java.util.Comparator;

public interface OurList<E> extends Iterable<E> {

    /**
     * the method returns the element by the index
     *
     * @param index
     * @return the element if the index is between 0 and size - 1
     * @throws IndexOutOfBoundsException otherwise
     */
    public E get(int index);

    /**
     * adds en element to the list
     *
     * @param elt
     */
    public void add(E elt);

    /**
     * removes the element by the index from the collection
     *
     * @param index
     * @return element to be removed
     * @throws IndexOutOfBoundsException in the index is incorrect
     */
    public E remove(int index);

    /**
     * removes the element if found in the collection
     *
     * @param elt to remove
     * @return true if found and removed, false otherwise
     */
    public boolean remove(E elt);

    /**
     * @return size of the collection
     */
    public int size();

    /**
     * puts the element by the index
     *
     * @param index
     * @param elt
     * @throws IndexOutOfBoundsException in the index is incorrect
     */
    public void set(int index, E elt);

    /**
     * @param elt
     * @return true if the element is found in the collection
     */
    public boolean contains(E elt);

    /**
     * The method must sort this list according to the comparator rule.
     *
     * @param comparator
     */
    public void sort(Comparator<E> comparator);
}
