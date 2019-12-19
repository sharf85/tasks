package com.telran.comparator;

public interface OurComparator<E> {

    /**
     * Compares two objects
     *
     * @param o1 first object to compare
     * @param o2 second object to compare
     * @return -1 if first is fewer, 0 if equals, 1 if larger
     */
    int compare(E o1, E o2);
}
