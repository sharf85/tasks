package com.telran.collection;

import com.telran.comparator.OurComparator;

public interface OurList {

    int size();

    void append(Object o);

    Object get(int index);

    void set(Object o, int index);

    Object removeById(int index);

    boolean remove(Object o);

    boolean contains(Object o);

    /**
     * finds max element int the list according to the comparator rule
     *
     * @param comparator an object comparing the elements of the list
     * @return max element according to comparator
     * @throws EmptyListException in case if the list is empty
     */
    Object max(OurComparator comparator);

    Object min(OurComparator comparator);

    void sort(OurComparator comparator);

}
