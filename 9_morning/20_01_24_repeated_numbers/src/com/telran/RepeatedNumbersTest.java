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
}