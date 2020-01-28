package com.telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PointsAndSegments {

    public List<Integer> getNumberCoveringSegmentsOverPoints(List<Double> numbers, List<Segment> segments) {

        List<Point> points = new ArrayList<>();
        for (double num : numbers) {
            points.add(new Point(num, Point.KIND_POINT));
        }

        for (Segment segment : segments) {
            points.add(new Point(segment.left, Point.KIND_LEFT));
            points.add(new Point(segment.right, Point.KIND_RIGHT));
        }

        Collections.sort(points);

        int counter = 0;
        List<Integer> res = new ArrayList<>();
        for (Point point : points) {
            if (point.kind == Point.KIND_LEFT) {
                counter++;
            } else if (point.kind == Point.KIND_RIGHT) {
                counter--;
            } else {
                res.add(counter);
            }
        }


        return res;
    }

    public static class Point implements Comparable<Point> {
        public final static int KIND_POINT = 1;
        public final static int KIND_LEFT = 0;
        public final static int KIND_RIGHT = 2;

        public Point(double val, int kind) {
            this.val = val;
            this.kind = kind;
        }

        double val;
        int kind;

        @Override
        public int compareTo(Point other) {
//            int res = Double.compare(this.val, other.val);
//            if (res != 0)
//                return res;
//
//            return Integer.compare(this.kind, other.kind);

            if (this.val < other.val)
                return -1;
            if (this.val > other.val)
                return 1;

            if (this.kind < other.kind)
                return -1;
            if (this.kind > other.kind)
                return 1;

            return 0;
        }
    }
}
