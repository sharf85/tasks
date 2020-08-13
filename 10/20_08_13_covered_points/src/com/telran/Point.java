package com.telran;

public class Point implements Comparable<Point> {
    int value;
    PointStatus status;

    public Point(int value, PointStatus status) {
        this.value = value;
        this.status = status;
    }

    @Override
    public int compareTo(Point other) {
        int res = this.value - other.value;
        if (res != 0)
            return res;

        res = this.status.ordinal() - other.status.ordinal();
        return res;
    }
}
