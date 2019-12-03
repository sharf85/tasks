package com.telran.comparator;

public abstract class AbstractComparator {

    /**
     * compares two object
     *
     * @param o1 the first object to compare
     * @param o2 the second object to compare
     * @return -1 in case if o1 < o2, 0 if o1 equals o2, 1 if o1 > o2
     */
    public abstract int compare(Object o1, Object o2);
}
