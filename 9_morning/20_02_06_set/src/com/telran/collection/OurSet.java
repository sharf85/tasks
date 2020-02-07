package com.telran.collection;

public interface OurSet<E> extends Iterable<E> {

    /**
     * adds a new element to the set
     *
     * @param elt to add
     * @return true if the set was changed
     */
    boolean add(E elt);

    /**
     * removes the element from the set
     *
     * @param elt to remove
     * @return true if the set was changed
     */
    boolean remove(E elt);

    /**
     * determines whether the elt is in the set
     *
     * @param elt to find
     * @return true is the set contains the elt
     */
    boolean contains(E elt);

    int size();

    /**
     * adds all the elements from the other to this set
     *
     * @param other elements of whom to be added
     * @return true if the set was changed
     */
    boolean addAll(OurSet<E> other);

    /**
     * removes all the elements appearing in the other from this set
     *
     * @param other elements of whom to be removed
     * @return true if the set was changed
     */
    boolean removeAll(OurSet<E> other);

    /**
     * retains all the elements appearing in the both this and the other sets
     *
     * @param other elements of whom, appearing also in this set, to be retained
     * @return true if the set was changed
     */
    boolean retainAll(OurSet<E> other);

}
