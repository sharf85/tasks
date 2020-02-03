package com.telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxStack {

    List<Integer> source = new ArrayList<>();

    public void addLast(Integer elt) {
        source.add(elt);
    }

    public Integer getLast() {
        return source.get(size() - 1);
    }

    public int size() {
        return source.size();
    }

    public Integer removeLast() {
        return source.remove(size() - 1);
    }

    public Integer max() {
        return Collections.max(source);
    }
}
