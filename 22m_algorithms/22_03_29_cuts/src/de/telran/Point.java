package de.telran;

public class Point implements Comparable<Point> {
    int value;
    boolean isLeft;

    @Override
    public int compareTo(Point anotherPoint) {
        // todo consider isLeft in the comparison
        return this.value - anotherPoint.value;
    }
}
