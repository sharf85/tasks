package com.telran.collection;

public interface OurSet<E> extends Iterable<E> {

    boolean add(E elt);

    boolean remove(E elt);

    boolean contains(E elt);

    int size();

    boolean addAll(OurSet<E> other);

    boolean removeAll(OurSet<E> other);

    boolean retainAll(OurSet<E> other);
}
