package com.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoveredNumbersTest {

    CoveredPointsFinder finder = new CoveredPointsFinder();

    @Test
    public void testGetMaxCoveredNumbers_noPoints_zero() {
        List<Double> numbers = Collections.emptyList();

        assertEquals(0, finder.getMaxPointsNum(numbers, 0.10001));
    }

    @Test
    public void testGetMaxCoveredNumbers_onePoints_one() {
        List<Double> numbers = Collections.singletonList(3.14);
        assertEquals(1, finder.getMaxPointsNum(numbers, 0.10001));
    }

    @Test
    public void testGetMaxCoveredNumbers_severalPointsAndSegment01_three() {
        List<Double> numbers = Arrays.asList(0.1, 0.3, 0.35, 0.4, 0.5, 0.57, 0.7);
        assertEquals(3, finder.getMaxPointsNum(numbers, 0.10001));
    }

    @Test
    public void testGetMaxCoveredNumbers_severalPointsAndSegment004_one() {
        List<Double> numbers = Arrays.asList(0.1, 0.3, 0.35, 0.4, 0.5, 0.57, 0.7);
        assertEquals(1, finder.getMaxPointsNum(numbers, 0.04001));
    }

    @Test
    public void testGetMaxCoveredNumbers_severalPointsAndSegment005_two() {
        List<Double> numbers = Arrays.asList(0.1, 0.3, 0.35, 0.4, 0.5, 0.57, 0.7);
        assertEquals(2, finder.getMaxPointsNum(numbers, 0.05001));
    }

    @Test
    public void testGetMaxCoveredNumbers_severalPointsAndSegment02_four() {
        List<Double> numbers = Arrays.asList(0.1, 0.3, 0.35, 0.4, 0.5, 0.57, 0.7);
        assertEquals(4, finder.getMaxPointsNum(numbers, 0.20001));
    }
}
