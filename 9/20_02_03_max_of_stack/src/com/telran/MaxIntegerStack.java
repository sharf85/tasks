package com.telran;

import java.util.*;

public class MaxIntegerStack {

    Deque<Integer> source = new ArrayDeque<>();
    Deque<Integer> maxSource = new ArrayDeque<>();

    public void addLast(Integer elt) {
        source.addLast(elt);
        if (size() == 0 || elt > max())
            maxSource.addLast(elt);
        else
            maxSource.addLast(max());
    }

    public Integer getLast() {
        return source.getLast();
    }

    public int size() {
        return source.size();
    }

    public Integer removeLast() {
        maxSource.removeLast();
        return source.removeLast();
    }

    public Integer max() {
        return maxSource.getLast();
    }
}
