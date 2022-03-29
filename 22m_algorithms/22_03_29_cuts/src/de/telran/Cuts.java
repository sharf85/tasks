package de.telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cuts {

    public int countMaxIntersectedCuts(List<Cut> cuts) {
        List<Point> points = convertToPoints(cuts);
        Collections.sort(points);

        int max = 0;
        int cutsCounter = 0;

        for (Point point : points) {
            // todo implement
        }

        return max;
    }

    private List<Point> convertToPoints(List<Cut> cuts) {
        List<Point> points = new ArrayList<>();
        // todo implement.
        return points;
    }
}
