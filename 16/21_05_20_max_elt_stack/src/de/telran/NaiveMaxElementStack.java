package de.telran;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;

public class NaiveMaxElementStack<E> implements IMaxElementStack<E> {

    ArrayDeque<E> stack;
    Comparator<E> comparator;

    public NaiveMaxElementStack() {
        comparator = new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                Comparable<E> comparable = (Comparable) o1;
                return comparable.compareTo(o2);
            }
        };

        stack = new ArrayDeque<>();
    }

    public NaiveMaxElementStack(Comparator<E> comparator) {
        this.comparator = comparator;
        stack = new ArrayDeque<>();
    }

    // O(1)
    @Override
    public void addLast(E elt) {
        stack.addLast(elt);
    }

    // O(1)
    @Override
    public E getLast() {
        return stack.getLast();
    }

    // O(1)
    @Override
    public E removeLast() {
        return stack.removeLast();
    }

    // O(n)
    @Override
    public E getMax() {
        return Collections.max(stack, comparator);
    }

    // O(1)
    @Override
    public int size() {
        return stack.size();
    }
}
