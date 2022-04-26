public class Point implements Comparable<Point> {
    int value;
    PointType type;

    public Point(int value, PointType type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public int compareTo(Point anotherPoint) {
        //todo implement
    }
}
