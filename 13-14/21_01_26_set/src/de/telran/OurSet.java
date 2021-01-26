package de.telran;

public interface OurSet<T> extends Iterable<T> {

    boolean add(T elt);

    boolean remove(T elt);

    boolean contains(T elt);

    int size();

    void addAll(OurSet<T> another);

    void retainAll(OurSet<T> another);

    void removeAll(OurSet<T> another);
}
