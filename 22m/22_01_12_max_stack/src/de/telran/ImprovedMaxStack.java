package de.telran;

import java.util.ArrayDeque;
import java.util.Deque;

//TODO complete
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
        return 0;
    }

    @Override
    public int remove() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }
}
