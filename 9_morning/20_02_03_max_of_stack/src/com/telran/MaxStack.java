package com.telran;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

public class MaxStack<E> {

    private Deque<E> source;
    private Deque<E> maxSource;
    private Comparator<E> comparator;

    public MaxStack(Comparator<E> comparator) {
        source = new ArrayDeque<>();
        maxSource = new ArrayDeque<>();
        this.comparator = comparator;
    }

    public MaxStack() {
        source = new ArrayDeque<>();
        maxSource = new ArrayDeque<>();
        this.comparator = new ComparatorBasedOnComparable<>();
    }

    public void addLast(E elt) {
        if (size() == 0 || comparator.compare(elt, maxSource.getLast()) > 0) {
            maxSource.addLast(elt);
        } else {
            maxSource.addLast(maxSource.getLast());
        }

        source.addLast(elt);
    }

    public E getLast() {
        return source.getLast();
    }

    public E removeLast() {
        maxSource.removeLast();
        return source.removeLast();
    }

    public int size() {
        return source.size();
    }

    public E getMax() {
        return maxSource.getLast();
    }

}

class ComparatorBasedOnComparable<E> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        Comparable o1comparable = (Comparable) o1;
        return o1comparable.compareTo(o2);
    }
}