package com.telran.model;

public class Point2D implements Comparable<Point2D> {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getR() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public int compareTo(Point2D other) {
        int thisRSquared = x * x + y * y;
        int otherRSquared = other.x * other.x + other.y * other.y;
        return thisRSquared - otherRSquared;
    }

}
