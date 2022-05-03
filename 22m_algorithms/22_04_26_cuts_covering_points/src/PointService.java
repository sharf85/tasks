import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PointService {

    Map<Integer, Integer> getCoveringCutsNumberByPoint(List<Integer> numbers, List<Cut> cuts) {

        List<Point> points = composeSortedPointList(numbers, cuts);
        Map<Integer, Integer> res = new HashMap<>();

        int opened = 0;
        for (Point point : points) {
            if (point.type == PointType.LEFT) {
                opened++;
            } else if (point.type == PointType.RIGHT) {
                opened--;
            } else {
                res.put(point.value, opened);
            }
        }

        return res;
    }

    private List<Point> composeSortedPointList(List<Integer> numbers, List<Cut> cuts) {
        List<Point> res = new ArrayList<>();

        for (int number : numbers) {
            res.add(new Point(number, PointType.NUMBER));
        }

        for (Cut cut : cuts) {
            res.add(new Point(cut.left, PointType.LEFT));
            res.add(new Point(cut.right, PointType.RIGHT));
        }

        Collections.sort(res);
        return res;

//        return Stream.concat(
//                numbers.stream().map(number -> new Point(number, PointType.NUMBER)),
//                cuts.stream().flatMap(cut -> Stream.of(new Point(cut.left, PointType.LEFT), new Point(cut.right, PointType.RIGHT))))
//                .sorted()
//                .collect(Collectors.toList());
    }
}
