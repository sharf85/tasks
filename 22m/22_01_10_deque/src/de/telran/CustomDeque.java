package de.telran;

public interface CustomDeque<T> extends Iterable<T> {

    void addFirst(T elt);

    T getFirst();

    T removeFirst();

    void addLast(T elt);

    T getLast();

    T removeLast();

    int size();
}
