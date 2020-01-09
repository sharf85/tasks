package com.telran;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class MaxPoints {
    public double naiveLeftCoordinateOfSegmentCoveringMaxPoints(List<Double> points, double d) {
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

    public double leftCoordinateOfSegmentCoveringMaxPoints(List<Double> points, double d) {
        double res = 0;
        int maxPoints = 0;

        Deque<Double> queue = new ArrayDeque<>();
        for (double point : points) {
            queue.add(point);
            while (queue.getFirst() < point - d) {
                queue.removeFirst();
            }

            if (queue.size() > maxPoints) {
                maxPoints = queue.size();
                res = queue.getFirst();
            }
        }

        return res;
    }
}
