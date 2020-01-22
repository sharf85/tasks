package com.telran;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PointsAndSegmentsTest {

    PointsAndSegments pas = new PointsAndSegments();

    @Test
    public void test_simple() {
        List<Double> points = Arrays.asList(2., 4., 7., 10., 12., 14., 8.5);
        List<Segment> segments = Arrays.asList(
                new Segment(0, 5),
                new Segment(1, 6),
                new Segment(3, 8),
                new Segment(9, 13),
                new Segment(11, 15)
        );

        List<Integer> expected = Arrays.asList(2, 3, 1, 0, 1, 2, 1);
        List<Integer> toCompare = pas.getNumberCoveringSegmentsOverPoints(points, segments);

        assertEquals(expected, toCompare);
    }

    @Test
    public void test_with_overlapping() {
        List<Double> points = Arrays.asList(2., 4., 7., 10., 12., 14.);
        List<Segment> segments = Arrays.asList(
                new Segment(0, 5),
                new Segment(1, 6),
                new Segment(3, 8),
                new Segment(9, 12),
                new Segment(12, 15)
        );

        List<Integer> expected = Arrays.asList(2, 3, 1, 1, 2, 1);
        List<Integer> toCompare = pas.getNumberCoveringSegmentsOverPoints(points, segments);

        assertEquals(expected, toCompare);
    }
}