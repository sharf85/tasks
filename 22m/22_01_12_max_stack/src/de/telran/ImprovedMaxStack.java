package de.telran;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImprovedMaxStack implements MaxStack {

    Deque<Integer> source = new ArrayDeque<>();
    Deque<Integer> currentMaxStack = new ArrayDeque<>();

    @Override
    public void add(int elt) {
        if (source.size() == 0)
            currentMaxStack.add(elt);
        else {
            int currentMax = Math.max(currentMaxStack.getLast(), elt);
            currentMaxStack.add(currentMax);
        }
        source.addLast(elt);
    }

    @Override
    public int get() {
        return source.getLast();
    }

    @Override
    public int remove() {
        currentMaxStack.removeLast();
        return source.removeLast();
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
