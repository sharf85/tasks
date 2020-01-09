package com.telran;

import java.util.List;

public class MaxPoints {
    public double getLeftCoordinateOfSegmentCoveringMaxPoints(List<Double> points, double d) {
        double res = 0;
        int maxPoints = 0;

        for (double leftCoordinate : points) {
            double rightCoordinate = leftCoordinate + d;
            int currentPointsNum = 0;

            for (double currentPoint : points) {
                if (currentPoint >= leftCoordinate && currentPoint <= rightCoordinate)
                    currentPointsNum++;
            }

            if (currentPointsNum > maxPoints) {
                maxPoints = currentPointsNum;
                res = leftCoordinate;
            }
        }

        return res;
    }
}
