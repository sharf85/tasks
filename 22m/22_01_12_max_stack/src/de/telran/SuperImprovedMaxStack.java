package de.telran;

import java.util.ArrayDeque;
import java.util.Deque;

public class SuperImprovedMaxStack implements MaxStack {

    Deque<Integer> source = new ArrayDeque<>();
    Deque<Integer> currentMaxStack = new ArrayDeque<>();

    @Override
    public void add(int elt) {
        if (source.size() == 0)
            currentMaxStack.addLast(elt);
        else if (elt >= currentMaxStack.getLast()) {
            currentMaxStack.addLast(elt);
        }
        source.addLast(elt);
    }

    @Override
    public int get() {
        return source.getLast();
    }

    @Override
    public int remove() {
        int res = source.removeLast();

        if (res == currentMaxStack.getLast()) {
            currentMaxStack.removeLast();
        }

        return res;
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public int getMax() {
        return currentMaxStack.getLast();
    }
}
