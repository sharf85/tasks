package com.telran;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class MaxPoints {
    public double getNaiveLeftCoordinateOfSegmentCoveringMaxPoints(List<Double> points, double d) {
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

    /**
     * The points list should be pre-sorted
     *
     * @param points
     * @param d
     * @return
     */
    public double getLeftCoordinateOfSegmentCoveringMaxPoints(List<Double> points, double d) {
        double res = 0;
        int maxPoints = 0;

        Deque<Double> queue = new ArrayDeque<>();

        for (double currentPoint : points) {
            queue.addLast(currentPoint);

            while (queue.getFirst() < currentPoint - d) {
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
