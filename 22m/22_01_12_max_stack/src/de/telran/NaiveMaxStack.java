package de.telran;

import java.util.ArrayDeque;
import java.util.Deque;

public class NaiveMaxStack implements MaxStack {

    private final Deque<Integer> source = new ArrayDeque<>();

    @Override
    public void add(int elt) {
        source.addLast(elt);
    }

    @Override
    public int get() {
        return source.getLast();
    }

    @Override
    public int remove() {
        return source.removeLast();
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public int getMax() {
        // ?

        for (int elt : source) {

        }
        return 0;
    }
}
