package com.telran.model;

import java.util.Comparator;

public class AlternativeNaturalPoint2DComparator implements Comparator<Point2D> {
    @Override
    public int compare(Point2D point1, Point2D point2) {
        double diff = point1.getR() - point2.getR();
        if (diff < 0)
            return -1;

        if (diff > 0)
            return 1;

        return 0;
    }
}
