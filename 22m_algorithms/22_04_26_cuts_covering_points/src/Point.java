public class Point implements Comparable<Point> {
    int value;
    PointType type;

    public Point(int value, PointType type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public int compareTo(Point anotherPoint) {
        if (this.value != anotherPoint.value)
            return Integer.compare(this.value, anotherPoint.value);

        if(this.type == anotherPoint.type)
            return 0;

        if(this.type == PointType.LEFT || anotherPoint.type == PointType.RIGHT)
            return -1;

        if(this.type == PointType.RIGHT || anotherPoint.type == PointType.LEFT)
            return 1;

        return 0;
    }
}
