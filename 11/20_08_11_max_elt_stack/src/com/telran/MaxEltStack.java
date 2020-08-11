package com.telran;

import java.util.ArrayDeque;
import java.util.Comparator;

public class MaxEltStack<T> {

    ArrayDeque<T> elements;
    ArrayDeque<T> maxValues;
    Comparator<T> comparator;

    MaxEltStack(Comparator<T> comparator) {
        this.comparator = comparator;
        elements = new ArrayDeque<>();
        maxValues = new ArrayDeque<>();
    }

    MaxEltStack() {
        elements = new ArrayDeque<>();
        maxValues = new ArrayDeque<>();
    }

    public void addLast(T elt) {
        if (elements.size() == 0) {
            maxValues.addLast(elt);
        } else {
            T lastMax = maxValues.getLast();
            if (comparator != null && comparator.compare(lastMax, elt) <= 0 ||
                    ((Comparable<T>) lastMax).compareTo(elt) <= 0)
                maxValues.addLast(elt);
        }

        elements.addLast(elt);
    }

    public T removeLast() {
        if (elements.size() == 0)
            throw new OurEmptyStackException();

        T lastElt = elements.removeLast();

        if (comparator != null && comparator.compare(lastElt, maxValues.getLast()) == 0
                || ((Comparable<T>) lastElt).compareTo(maxValues.getLast()) == 0) {
            maxValues.removeLast();
        }

        return lastElt;
    }

    public T getLast() {
        if (elements.size() == 0)
            throw new OurEmptyStackException();

        return elements.getLast();
    }

    public T getMax() {
        if (elements.size() == 0)
            throw new OurEmptyStackException();

        return maxValues.getLast();
    }

    public int size() {
        return elements.size();
    }

}
