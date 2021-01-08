package de.telran;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public interface OurList<Type> extends Iterable<Type> {

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

    /**
     * sorts the list according to the 'comparator' rule
     *
     * @param comparator the rule to sort the list
     */
    default void sort(Comparator<Type> comparator) {
        Type[] copy = (Type[]) new Object[size()];

        int i = 0;
        for (Type elt : this) {
            copy[i++] = elt;
        }//copy: {15, -8, 3}

        Arrays.sort(copy, comparator);

        // copy:{-8, 3, 15}
        this.clear();
        for (Type elt : copy) {
            this.addLast(elt);
        }
    }

    default Type max(Comparator<Type> comparator) {
        if (size() == 0)
            throw new NoSuchElementException();

//        Iterator<Type> iterator = iterator();
//        Type max = iterator.next();
//
//        while (iterator.hasNext()) {
//            Type currentElt = iterator.next();
//            if (comparator.compare(currentElt, max) > 0)
//                max = currentElt;
//        }

        Type max = this.get(0);

        for (Type currentElt : this) {
            if (comparator.compare(currentElt, max) > 0)
                max = currentElt;
        }

        return max;
    }

    default Type min(Comparator<Type> comparator) {
        return max(comparator.reversed());
    }

}
