package com.telran.comparator;

public interface OurComparator {

    /**
     * Compares two objects
     *
     * @param o1 first object to compare
     * @param o2 second object to compare
     * @return -1 if first is fewer, 0 if equals, 1 if larger
     */
    int compare(Object o1, Object o2);
}
