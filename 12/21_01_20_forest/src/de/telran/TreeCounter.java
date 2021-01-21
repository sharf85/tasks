package de.telran;


import java.util.*;

public class TreeCounter {

    /**
     * Counts the max amount of trees visible from the point (0, 0) with the angle of
     * visibility alpha
     *
     * @param trees list of the 2D points (has x and y coordinates)
     * @param alpha the angle of visibility
     * @return
     */
    public int treeCount(List<Point2D> trees, double alpha) {
        List<Double> angles = getSortedAngles(trees, alpha);
        return numbersCount(angles, alpha);
    }

    private List<Double> getSortedAngles(List<Point2D> trees, double alpha) {
//        return trees.stream()
//                .flatMap(point2D -> {
//                    double angle = point2D.getAngleRads();
//                    return angle < alpha ? Stream.of(angle, angle + 2 * Math.PI) : Stream.of(angle);
//                })
//                .sorted()
//                .collect(Collectors.toList());


        List<Double> res = new ArrayList<>();
        for (Point2D point2D : trees) {
            double angle = point2D.getAngleRads();
            res.add(angle);

            if (angle < alpha)
                res.add(angle + 2 * Math.PI);
        }

        Collections.sort(res);
        return res;
    }

    /**
     * @return the max amount of numbers covered by an interval
     */
    int numbersCount(List<Double> numbers, double interval) {
        if (numbers.isEmpty() || interval == 0)
            return 0;

        Deque<Double> intervalQueue = new ArrayDeque<>();
        int max = 0;
        for (double number : numbers) {
            intervalQueue.addLast(number);

            while (number - intervalQueue.getFirst() > interval) {
                intervalQueue.removeFirst();
            }

            if (max < intervalQueue.size())
                max = intervalQueue.size();
        }

        return max;
    }

}
