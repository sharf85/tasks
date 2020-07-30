package com.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwoDivisorsTest {

    TwoDivisors divisors = new TwoDivisors();
    List<Integer> nums = Arrays.asList(2, 3, 8, 9, 9, 15, 20);

    @Test
    public void testIsDivisors_NEquals2_false() {
        assertFalse(divisors.isDivisors(nums, 2));
    }

    @Test
    public void testIsDivisors_NEquals20_false() {
        assertFalse(divisors.isDivisors(nums, 20));
    }

    @Test
    public void testIsDivisors_NEquals1_false() {
        assertFalse(divisors.isDivisors(nums, 1));
    }

    @Test
    public void testIsDivisors_NEquals400_false() {
        assertFalse(divisors.isDivisors(nums, 400));
    }

    @Test
    public void testIsDivisors_NEquals7_false() {
        assertFalse(divisors.isDivisors(nums, 7));
    }

    @Test
    public void testIsDivisors_NEquals27_true() {
        assertTrue(divisors.isDivisors(nums, 27));
    }

    @Test
    public void testIsDivisors_NEquals75_false() {
        assertFalse(divisors.isDivisors(nums, 75));
    }

    @Test
    public void testIsDivisors_NEquals64_false() {
        assertFalse(divisors.isDivisors(nums, 64));
    }

    @Test
    public void testIsDivisors_NEquals81_true() {
        assertTrue(divisors.isDivisors(nums, 81));
    }

    @Test
    public void testIsDivisors_NEquals45_true() {
        assertTrue(divisors.isDivisors(nums, 45));
    }

    @Test
    public void testIsDivisors_NEquals160_true() {
        assertTrue(divisors.isDivisors(nums, 160));
    }

    @Test
    public void testIsDivisors_NEquals72_true() {
        assertTrue(divisors.isDivisors(nums, 72));
    }
}
