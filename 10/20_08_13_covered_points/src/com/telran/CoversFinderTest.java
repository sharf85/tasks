package com.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoversFinderTest {

    CoversFinder segmentsAndPoints = new CoversFinder();

    @Test
    public void testGetNumCover_emptyPointsEmptySegments_emptyList() {
        List<Integer> points = Arrays.asList();
        List<Segment> segments = Arrays.asList();
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, segmentsAndPoints.find(points, segments));
    }

    @Test
    public void testGetNumCover_onePointsOneSegments_List1() {
        List<Integer> points = Arrays.asList(1);
        List<Segment> segments = Arrays.asList(new Segment(0, 2));
        List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, segmentsAndPoints.find(points, segments));
    }

    @Test
    public void testGetNumCover_onePointsOneAnotherSegments_List0() {
        List<Integer> points = Arrays.asList(1);
        List<Segment> segments = Arrays.asList(new Segment(2, 4));
        List<Integer> expected = Arrays.asList(0);
        assertEquals(expected, segmentsAndPoints.find(points, segments));
    }

    @Test
    public void testGetNumCover_onePointManySegments_List1() {
        List<Integer> points = Arrays.asList(3);
        List<Segment> segments = Arrays.asList(new Segment(2, 4), new Segment(0, 4),
                new Segment(1, 3));
        List<Integer> expected = Arrays.asList(3);
        assertEquals(expected, segmentsAndPoints.find(points, segments));
    }

    @Test
    public void testGetNumCover_manyPointsOneLongSegments_anyList() {
        List<Integer> points = Arrays.asList(3, 5, 7);
        List<Segment> segments = Arrays.asList(new Segment(1, 9));
        List<Integer> expected = Arrays.asList(1, 1, 1);
        assertEquals(expected, segmentsAndPoints.find(points, segments));
    }

    @Test
    public void testGetNumCover_manyPointsOneSegments_anyList() {
        List<Integer> points = Arrays.asList(3, 5, 7);
        List<Segment> segments = Arrays.asList(new Segment(1, 4));
        List<Integer> expected = Arrays.asList(1, 0, 0);
        assertEquals(expected, segmentsAndPoints.find(points, segments));
    }

    @Test
    public void testGetNumCover_anyPointsAnySegments_anyList() {
        List<Integer> points = Arrays.asList(1, 2, 3, 4, 5);
        List<Segment> segments = Arrays.asList(
                new Segment(0, 2),
                new Segment(4, 5)
        );
        List<Integer> expected = Arrays.asList(1, 1, 0, 1, 1);
        assertEquals(expected, segmentsAndPoints.find(points, segments));
    }
}
