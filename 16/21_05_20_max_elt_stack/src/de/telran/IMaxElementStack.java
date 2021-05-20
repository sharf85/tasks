package de.telran;

import java.util.Comparator;

/**
 * Every implementation must have constructors only with Comparator<E>
 *
 * @param <E>
 */
public interface IMaxElementStack<E> {

    void addLast(E elt);

    E getLast();

    E removeLast();

    E getMax();

    int size();
}
