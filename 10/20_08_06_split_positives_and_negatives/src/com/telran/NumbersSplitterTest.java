package com.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersSplitterTest {
    NumbersSplitter numbersSplitter = new NumbersSplitter();

    @Test
    public void testSaparateInteger_zero_zero() {
        List<Integer> list = Arrays.asList(0);
        assertEquals(Arrays.asList(0), numbersSplitter.split(list));
    }

    @Test
    public void testSaparateInteger_allZero_allZero() {
        List<Integer> list = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0);
        assertEquals(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), numbersSplitter.split(list));
    }

    @Test
    public void testSaparateInteger_minus_minus() {
        List<Integer> list = Arrays.asList(-3, -5, -1);
        assertEquals(Arrays.asList(-3, -5, -1), numbersSplitter.split(list));
    }

    @Test
    public void testSaparateInteger_plus_plus() {
        List<Integer> list = Arrays.asList(8, 0, 3, 10);
        assertEquals(Arrays.asList(8, 0, 3, 10), numbersSplitter.split(list));
    }

    @Test
    public void testSaparateInteger_minusAndPlus_rightList() {
        List<Integer> list = Arrays.asList(8, 3, -3, 10, -5, -1);
        assertEquals(Arrays.asList(-3, -5, -1, 8, 3, 10), numbersSplitter.split(list));
    }

    @Test
    public void testSaparateInteger_minusAndPlusAndZero_rightList() {
        List<Integer> list = Arrays.asList(8, 0, 3, -3, 10, -5, -1);
        assertEquals(Arrays.asList(-3, -5, -1, 8, 0, 3, 10), numbersSplitter.split(list));
    }

    @Test
    public void testSaparateInteger_minusAndPlusAndZeroDoubleNumbers_rightList() {
        List<Integer> list = Arrays.asList(8, 0, 8, -3, 3, -3, 10, -5, -1);
        assertEquals(Arrays.asList(-3, -3, -5, -1, 8, 0, 8, 3, 10), numbersSplitter.split(list));
    }

}
