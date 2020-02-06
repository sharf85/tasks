package com.telran;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class NumbersTest {

    Numbers numbers = new Numbers();

    @Test
    public void testCheckArray_NonSumInArray_False() {
        List<Integer> list = Arrays.asList(2, 5, 8, 10);
        int ourNumber = 9;
        assertFalse(numbers.twoNumbersMakesSum(ourNumber, list));
    }

    @Test
    public void testCheckArray_SumInArray_True() {
        List<Integer> list = Arrays.asList(1, 5, 8, 10);
        int ourNumber = 9;
        assertTrue(numbers.twoNumbersMakesSum(ourNumber, list));
    }
}