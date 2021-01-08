package de.telran;

import java.util.ArrayDeque;
import java.util.Comparator;

public class CompressedBufferedStackMax<T> implements IStackMax<T> {
    private final ArrayDeque<T> source;
    private final ArrayDeque<T> currentMax;
    private final Comparator<T> comparator;

    public CompressedBufferedStackMax(Comparator<T> comparator) {
        this.comparator = comparator;
        source = new ArrayDeque<>();
        currentMax = new ArrayDeque<>();
    }

    public void addLast(T elt) {
        if (source.size() == 0 ||
//                elt > currentMax.getLast()
                comparator.compare(elt, currentMax.getLast()) >= 0)
            currentMax.addLast(elt);

        source.addLast(elt);
    }

    public T getLast() {
        return source.getLast();
    }

    public T removeLast() {
        T res = source.removeLast();
        T currentMaxElt = currentMax.getLast();

        if (comparator.compare(res, currentMaxElt) == 0)
            currentMax.removeLast();

        return res;
    }

    public int size() {
        return source.size();
    }

    public T getMax() {
        return currentMax.getLast();
    }

}
