package de.telran;

public class Point implements Comparable<Point> {
    int value;
    boolean isLeft;

    public Point(int value, boolean isLeft) {
        this.value = value;
        this.isLeft = isLeft;
    }

    @Override
    public int compareTo(Point anotherPoint) {
        int res = this.value - anotherPoint.value;
        if (res != 0)
            return res;

        if (this.isLeft && !anotherPoint.isLeft)
            return -1;
        if (!this.isLeft && anotherPoint.isLeft)
            return 1;

        return 0;
    }
}
