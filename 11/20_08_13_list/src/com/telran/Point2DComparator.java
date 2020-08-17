package com.telran;

import java.util.Comparator;

public class Point2DComparator implements Comparator<Point2D> {
    @Override
    public int compare(Point2D o1, Point2D o2) {
        int o1RSquared = computeRSquared(o1);
        int o2RSquared = computeRSquared(o2);
        return o1RSquared - o2RSquared;
    }

    int computeRSquared(Point2D point) {
        return point.x * point.x + point.y * point.y;
    }
}
