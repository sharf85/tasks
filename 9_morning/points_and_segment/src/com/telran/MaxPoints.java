package com.telran;

import java.util.List;

public class MaxPoints {
    public double leftCoordinateOfSegmentCoveringMaxPoints(List<Double> points, double d) {
        double res = 0;
        int maxPoints = 0;

        for (double leftCoordinate : points) {
            double rightCoordinate = leftCoordinate + d;
            int coveredPoints = 0;

            for (double currentPoint : points) {
                if (currentPoint >= leftCoordinate && currentPoint <= rightCoordinate)
                    coveredPoints++;
            }

            if (coveredPoints > maxPoints) {
                maxPoints = coveredPoints;
                res = leftCoordinate;
            }
        }

        return res;
    }
}
