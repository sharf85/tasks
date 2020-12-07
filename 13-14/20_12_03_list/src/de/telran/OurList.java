package de.telran;

import java.util.Iterator;

public interface OurList<Type> {

    /**
     * Adds the element to the 'this' instance
     *
     * @param element - to add
     */
    void addLast(Type element);

    /**
     * @param index - index of the element to return. It must be in the range between 0 and (size-1).
     * @return returns the element by the index
     */
    Type get(int index);

    /**
     * sets the value to the index place in the 'this' instance
     *
     * @param index the place to set
     * @param value the value to set
     */
    void set(int index, Type value);

    /**
     * removes the element by the index
     *
     * @param index the index of the element to remove
     * @return the value of the removed element
     */
    Type removeById(int index);

    /**
     * @return the size of 'this'
     */
    int size();

    /**
     * makes 'this' empty
     */
    void clear();

    /**
     * removes the obj if there is an element in the list which 'equals' to the obj. The method
     * must remove only first such element.
     *
     * @param obj to remove
     * @return true if the object was found and removed, false otherwise
     */
    boolean remove(Type obj);

    /**
     * @param obj to check
     * @return true if the obj is present in this list (according to the method 'equals')
     */
    boolean contains(Type obj);

    /**
     * @return iterator object which iterates from the beginning to the end of the list
     */
    Iterator<Type> forwardIterator();

    /**
     * @return iterator object which iterates from the end to the beginning of the list
     */
    Iterator<Type> backwardIterator();
}
