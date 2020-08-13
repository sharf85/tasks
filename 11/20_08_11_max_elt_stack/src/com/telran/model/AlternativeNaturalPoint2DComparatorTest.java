package com.telran.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlternativeNaturalPoint2DComparatorTest {

    AlternativeNaturalPoint2DComparator comparator = new AlternativeNaturalPoint2DComparator();

    @Test
    public void testCompareTo_positivesP1Farther_True() {
        Point2D p1 = new Point2D(3, 3);
        Point2D p2 = new Point2D(3, 2);
        assertTrue(comparator.compare(p1, p2) > 0);
    }

    @Test
    public void testCompareTo_positivesP1Closer_True() {
        Point2D p1 = new Point2D(2, 3);
        Point2D p2 = new Point2D(4, 5);
        assertTrue(comparator.compare(p1, p2) < 0);
    }

    @Test
    public void testCompareTo_positivesP2Farther_True() {
        Point2D p1 = new Point2D(3, 1);
        Point2D p2 = new Point2D(5, 6);
        assertTrue(comparator.compare(p2, p1) > 0);
    }

    @Test
    public void testCompareTo_positivesP2Closer_True() {
        Point2D p1 = new Point2D(4, 5);
        Point2D p2 = new Point2D(2, 3);
        assertTrue(comparator.compare(p2, p1) < 0);
    }

    @Test
    public void testCompareTo_negativesP1Farther_True() {
        Point2D p1 = new Point2D(-10, -3);
        Point2D p2 = new Point2D(-3, -4);
        assertTrue(comparator.compare(p1, p2) > 0);
    }

    @Test
    public void testCompareTo_negativesP1Closer_True() {
        Point2D p1 = new Point2D(-2, -3);
        Point2D p2 = new Point2D(-4, -5);
        assertTrue(comparator.compare(p1, p2) < 0);
    }

    @Test
    public void testCompareTo_negativesP2Farther_True() {
        Point2D p1 = new Point2D(-3, -1);
        Point2D p2 = new Point2D(-5, -6);
        assertTrue(comparator.compare(p2, p1) > 0);
    }

    @Test
    public void testCompareTo_negativesP2Closer_True() {
        Point2D p1 = new Point2D(-4, -5);
        Point2D p2 = new Point2D(-2, -3);
        assertTrue(comparator.compare(p2, p1) < 0);
    }

    @Test
    public void testCompareTo_mixedCoordinates_True() {
        Point2D p1 = new Point2D(1, -2);
        Point2D p2 = new Point2D(-3, 4);
        assertTrue(comparator.compare(p1, p2) < 0);
    }

    @Test
    public void testCompareTo_negativesSameDistance_True() {
        Point2D p1 = new Point2D(-3, -3);
        Point2D p2 = new Point2D(-3, -3);
        assertTrue(comparator.compare(p1, p2) == 0);
    }

    @Test
    public void testCompareTo_oneIsInZero_True() {
        Point2D p1 = new Point2D(0, 0);
        Point2D p2 = new Point2D(-3, -3);
        assertTrue(comparator.compare(p1, p2) < 0);
    }

    @Test
    public void testCompareTo_bothAreInZero_True() {
        Point2D p1 = new Point2D(0, 0);
        Point2D p2 = new Point2D(0, 0);
        assertTrue(comparator.compare(p1, p2) == 0);
    }

}
