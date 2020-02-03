package com.telran;

import java.util.Collections;
import java.util.List;

public class MaxStack {

    private List<Integer> source;
    private List<Integer> maxSource;

    public void addLast(Integer elt) {
        if (size() == 0 || elt > maxSource.get(size() - 1)) {
            maxSource.add(elt);
        } else {
            maxSource.add(maxSource.get(size() - 1));
        }

        source.add(elt);
    }

    public Integer getLast() {
        return source.get(size() - 1);
    }

    public Integer removeLast() {
        maxSource.remove(size() - 1);
        return source.remove(size() - 1);
    }

    public int size() {
        return source.size();
    }

    public Integer getMax() {
        return maxSource.get(size() - 1);
    }

}
