package de.telran;

/**
 * The implementations of the interface should be able to work with the last and the first
 * elements efficiently. Namely, add, remove and get
 *
 * @param <T> the type of the elements stored in the deque
 */
public interface OurDeque<T> {

    /**
     * @param elt
     * @throws DequeOverflowException if the implementation may contain limited number of elements, than the method throws
     */
    void addFirst(T elt);

    T getFirst();

    T removeFirst();

    void addLast(T elt);

    T getLast();

    T removeLast();

    int size();
}
