package com.telran;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayNegativesToPositivesIterator implements Iterator<Integer> {

    ArrayList<Integer> buffer;

    ArrayNegativesToPositivesIterator(int[] source) {
        init(source);
    }

    private void init(int[] source) {
        buffer = new ArrayList<>();
        List<Integer> nonNegatives = new ArrayList<>();

        for (int num : source) {
            if (num < 0)
                buffer.add(num);
            else
                nonNegatives.add(num);
        }

        buffer.addAll(nonNegatives);
    }

    int currentIndex;

    @Override
    public boolean hasNext() {
        return currentIndex < buffer.size();
    }

    @Override
    public Integer next() {
        int currentNum = buffer.get(currentIndex);
        currentIndex++;
        return currentNum;
    }
}
