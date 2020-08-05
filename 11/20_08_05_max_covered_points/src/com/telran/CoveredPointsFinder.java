package com.telran;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CoveredPointsFinder {

    public int getMaxPointsNum(List<Double> points, double l) {
        Deque<Double> segment = new ArrayDeque<>();

        int res = 0;

        for (double point : points) {
            double leftEnd = point - l;
            segment.addLast(point);

            while (segment.getFirst() < leftEnd)
                segment.removeFirst();

            if (res < segment.size())
                res = segment.size();
        }

        return res;
    }
}
