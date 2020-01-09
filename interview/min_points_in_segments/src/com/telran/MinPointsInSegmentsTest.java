package com.telran;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.*;

public class MinPointsInSegmentsTest {
    MinPointsInSegments minPointsInSegments = new MinPointsInSegments();

    @Test
    public void testGetMinPointsNumber_segments() {
        List<Segment> segments = Arrays.asList(
                new Segment(0.6, 0.9),
                new Segment(0.2, 0.7),
                new Segment(0.4, 0.8),
                new Segment(0.1, 0.5),
                new Segment(0, 0.3)
        );

        assertEquals(2, minPointsInSegments.getMinPointsNumber(segments));
    }

    @Test
    public void testGetMinPointsNumber_points() {
        List<Segment> segments = Arrays.asList(
                new Segment(0.6, 0.6),
                new Segment(0.2, 0.2),
                new Segment(0.4, 0.7),
                new Segment(0.1, 0.1),
                new Segment(0, 0)
        );

        assertEquals(4, minPointsInSegments.getMinPointsNumber(segments));
    }
}
