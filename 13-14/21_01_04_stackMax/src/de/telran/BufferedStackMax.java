package de.telran;

import java.util.ArrayDeque;
import java.util.Comparator;

public class BufferedStackMax<T> implements IStackMax<T>{

    private final ArrayDeque<T> source;
    private final ArrayDeque<T> currentMax;
    private final Comparator<T> comparator;

    public BufferedStackMax(Comparator<T> comparator) {
        this.comparator = comparator;
        source = new ArrayDeque<>();
        currentMax = new ArrayDeque<>();
    }

    public void addLast(T elt) {
        if (source.size() == 0 ||
//                elt > currentMax.getLast()
                comparator.compare(elt, currentMax.getLast()) > 0)
            currentMax.addLast(elt);
        else
            currentMax.addLast(currentMax.getLast());

        source.addLast(elt);
    }

    public T getLast() {
        return source.getLast();
    }

    public T removeLast() {
        currentMax.removeLast();
        return source.removeLast();
    }

    public int size() {
        return source.size();
    }

    public T getMax() {
        return currentMax.getLast();
    }
}
