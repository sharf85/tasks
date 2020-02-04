package com.telran;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxIntegerStack {

    private Deque<Integer> source;
    private Deque<Integer> maxSource;

    public MaxIntegerStack() {
        source = new ArrayDeque<>();
        maxSource = new ArrayDeque<>();
    }

    public void addLast(Integer elt) {
        if (size() == 0 || elt > maxSource.getLast()) {
            maxSource.add(elt);
        } else {
            maxSource.add(maxSource.getLast());
        }

        source.add(elt);
    }

    public Integer getLast() {
        return source.getLast();
    }

    public Integer removeLast() {
        maxSource.removeLast();
        return source.removeLast();
    }

    public int size() {
        return source.size();
    }

    public Integer getMax() {
        return maxSource.getLast();
    }

}
