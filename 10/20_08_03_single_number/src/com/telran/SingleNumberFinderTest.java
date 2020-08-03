package com.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumberFinderTest {

    SingleNumberFinder finder = new SingleNumberFinder();

    @Test
    public void testFind_oneNumber_returnsSingleNumber() {
        List<Integer> numbers = Arrays.asList(7);
        assertEquals(7, finder.find(numbers));
    }

    @Test
    public void testFind_singleNumberAndPairOfNumbers_singleNumber() {
        List<Integer> numbers = Arrays.asList(-5, 7, -5);
        assertEquals(7, finder.find(numbers));
    }

    @Test
    public void testFind_threeSameNumbers_returnsNumber() {
        List<Integer> numbers = Arrays.asList(-5, -5, -5);
        assertEquals(-5, finder.find(numbers));
    }

    @Test
    public void testFind_5threeTimesAnd9twoTimes_5() {
        List<Integer> numbers = Arrays.asList(5, 9, 9, 5, 5);
        assertEquals(5, finder.find(numbers));
    }

    @Test
    public void testFind_5threeTimesAnd9twoTimes7fourTimes_5() {
        List<Integer> numbers = Arrays.asList(5, 9, 7, 7, 9, 5, 7, 5, 7);
        assertEquals(5, finder.find(numbers));
    }

    @Test
    public void testFind_5fourTimesAnd9OneTimes_5() {
        List<Integer> numbers = Arrays.asList(5, 9, 5, 5, 5);
        assertEquals(9, finder.find(numbers));
    }

}
