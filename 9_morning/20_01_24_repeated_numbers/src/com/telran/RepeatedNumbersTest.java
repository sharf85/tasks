package com.telran;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RepeatedNumbersTest {
    RepeatedNumbers rp = new RepeatedNumbers();

    @Test
    public void testGetQtyRepeatedNumbers_noRepeatedNumbers_zero() {
        List<Integer> ints = Arrays.asList(1, 3, -8, 24, -20);
        assertEquals(0, rp.getQtyRepeatedNumbers(ints));
    }

    @Test
    public void testGetQtyRepeatedNumbers_oneRepeatedNumbersOnes_1() {
        List<Integer> ints = Arrays.asList(1, 3, -8, 24, -20, -8);
        assertEquals(1, rp.getQtyRepeatedNumbers(ints));
    }

    @Test
    public void testGetQtyRepeatedNumbers_oneRepeatedNumberSeveralTimes_1() {
        List<Integer> ints = Arrays.asList(1, 3, -8, 24, -20, -8, 67, -8, -8);
        assertEquals(1, rp.getQtyRepeatedNumbers(ints));
    }

    @Test
    public void testGetQtyRepeatedNumbers_threeRepeatedNumberSeveralTimes_3() {
        List<Integer> ints = Arrays.asList(1, 3, -8, 24, 1, -20, -8, 67, 24, -8, 24, -8);
        assertEquals(3, rp.getQtyRepeatedNumbers(ints));
    }

    @Test
    public void testGetSingleNumber_3numbers2different() {
        List<Integer> ints = Arrays.asList(1, 3, 1);
        assertEquals(3, rp.getSingleNumber(ints));
        assertEquals(3, rp.getSingleNumberAdvanced(ints));

    }

    @Test
    public void testGetSingleNumber_3numbers1different() {
        List<Integer> ints = Arrays.asList(1, 1, 1);
        assertEquals(1, rp.getSingleNumber(ints));
        assertEquals(1, rp.getSingleNumberAdvanced(ints));

    }

    @Test
    public void testGetSingleNumber_5numbers4same() {
        List<Integer> ints = Arrays.asList(-1, -1, 5, -1, -1);
        assertEquals(5, rp.getSingleNumber(ints));
        assertEquals(5, rp.getSingleNumberAdvanced(ints));

    }

    @Test
    public void testGetSingleNumber_5numbers3different() {
        List<Integer> ints = Arrays.asList(1, -4, -5, -4, 1);
        assertEquals(-5, rp.getSingleNumber(ints));
        assertEquals(-5, rp.getSingleNumberAdvanced(ints));

    }

    @Test
    public void testGetSingleNumber_5numbers3same() {
        List<Integer> ints = Arrays.asList(1, 4, 4, 4, 1);
        assertEquals(4, rp.getSingleNumber(ints));
        assertEquals(4, rp.getSingleNumberAdvanced(ints));

    }
}