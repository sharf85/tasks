package com.telran;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

public class MaxStack<E> {

    private Deque<E> source = new ArrayDeque<>();
    private Deque<E> maxSource = new ArrayDeque<>();

    private Comparator<E> comparator;

    public MaxStack(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public MaxStack() {
        this.comparator = (E o1, E o2) -> {
            Comparable<E> newO1 = (Comparable) o1;
            return newO1.compareTo(o2);
        };
    }

    public void addLast(E elt) {
        if (size() == 0 || comparator.compare(elt, max()) > 0)
            maxSource.addLast(elt);
        else
            maxSource.addLast(max());
        source.addLast(elt);
    }

    public E getLast() {
        return source.getLast();
    }

    public int size() {
        return source.size();
    }

    public E removeLast() {
        maxSource.removeLast();
        return source.removeLast();
    }

    public E max() {
        return maxSource.getLast();
    }
}

class ComparatorForComparable<E> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        Comparable<E> newO1 = (Comparable) o1;
        return newO1.compareTo(o2);
    }
}