package com.telran.collection;

import com.telran.comparator.OurComparator;

public interface OurList<E> {

    int size();

    void append(E o);

    E get(int index);

    void set(E o, int index);

    E removeById(int index);

    boolean remove(E o);

    boolean contains(E o);

    /**
     * finds max element int the list according to the comparator rule
     *
     * @param comparator an object comparing the elements of the list
     * @return max element according to comparator
     * @throws EmptyListException in case if the list is empty
     */
    E max(OurComparator<E> comparator);

    E min(OurComparator<E> comparator);

    void sort(OurComparator<E> comparator);

}
