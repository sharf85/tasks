package de.telran;

import java.util.ArrayDeque;
import java.util.Comparator;

public class EffectiveMaxElementStack<E> implements IMaxElementStack<E> {
    ArrayDeque<E> stack;
    Comparator<E> comparator;
    ArrayDeque<E> maxElementsInStack;

    public EffectiveMaxElementStack(Comparator<E> comparator) {
        this.comparator = comparator;
        stack = new ArrayDeque<>();
        maxElementsInStack = new ArrayDeque<>();
    }

    public EffectiveMaxElementStack() {
        comparator = new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                Comparable<E> comparable = (Comparable<E>) o1;
                return comparable.compareTo(o2);
            }
        };
        stack = new ArrayDeque<>();
        maxElementsInStack = new ArrayDeque<>();
    }


    @Override
    public void addLast(E elt) {
        if (maxElementsInStack.size() == 0) {
            maxElementsInStack.addLast(elt);
        } else if (comparator.compare(elt, maxElementsInStack.getLast()) >= 0) {
            maxElementsInStack.addLast(elt);
        }
        stack.addLast(elt);
    }

    @Override
    public E getLast() {
        return stack.getLast();
    }

    @Override
    public E removeLast() {
        E elementToRemove = stack.removeLast();
        if (comparator.compare(elementToRemove, maxElementsInStack.getLast()) == 0)
            maxElementsInStack.removeLast();
        return elementToRemove;
    }

    @Override
    public E getMax() {
        return maxElementsInStack.getLast();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
