package de.telran;

import java.util.ArrayDeque;

public class StackMax {

    private final ArrayDeque<Integer> source;
    private final ArrayDeque<Integer> currentMax;

    public StackMax() {
        source = new ArrayDeque<>();
        currentMax = new ArrayDeque<>();
    }

    public void addLast(int elt) {
        source.addLast(elt);
    }

    public int getLast() {
        return source.getLast();
    }

    public int removeLast() {

    }

    public int size() {

    }

    public int getMax() {
        // foreach here over all the elements of the 'source'
    }
}
