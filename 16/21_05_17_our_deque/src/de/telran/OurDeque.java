package de.telran;

public interface OurDeque<E> extends Iterable<E>{
    void addLast(E elt);

    void addFirst(E elt);

    /**
     * @return
     * @throws java.util.NoSuchElementException if no elements in the collection
     */
    E removeFirst();

    /**
     * @return
     * @throws java.util.NoSuchElementException if no elements in the collection
     */
    E removeLast();

    /**
     * @return
     * @throws java.util.NoSuchElementException if no elements in the collection
     */
    E getFirst();

    /**
     * @return
     * @throws java.util.NoSuchElementException if no elements in the collection
     */
    E getLast();

    int size();
}
