package de.telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CutService {

    public int countMaxIntersectedCuts(List<Cut> cuts) {
        List<Point> points = convertToPoints(cuts);
        Collections.sort(points);

        int max = 0;
        int cutsCounter = 0;

        for (Point point : points) {
            if (point.isLeft) {
                if (max < ++cutsCounter)
                    max = cutsCounter;
            } else {
                cutsCounter--;
            }

        }

        return max;
    }

    private List<Point> convertToPoints(List<Cut> cuts) {
        List<Point> points = new ArrayList<>();

        for (Cut cut : cuts) {
            points.add(new Point(cut.left, true));
            points.add(new Point(cut.right, false));
        }

        return points;

//        return cuts.stream()
//                .flatMap(cut -> Stream.of(new Point(cut.left, true), new Point(cut.right, false)))
//                .collect(Collectors.toList());
    }
}
