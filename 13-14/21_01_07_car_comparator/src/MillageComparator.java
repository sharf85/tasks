import java.util.Comparator;

public class MillageComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.millage - o2.millage;
    }
}
