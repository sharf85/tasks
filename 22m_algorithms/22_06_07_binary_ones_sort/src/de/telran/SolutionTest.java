package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test_1() {
        List<Integer> list = Arrays.asList(5, 8, 2, 4, 3, 128);
        solution.sortByBinaryOnesAndValue(list);
        List<Integer> res = Arrays.asList(2, 4, 8, 128, 3, 5);
        assertEquals(res, list);
    }

    @Test
    public void test_2() {
        List<Integer> list = Arrays.asList(6, 13, 22, 128, 1); // 110, 1101, 10110, 10000000, 1
        solution.sortByBinaryOnesAndValue(list);
        List<Integer> res = Arrays.asList(1, 128, 6, 13, 22);
        assertEquals(res, list);
    }

    @Test
    public void test_sortByBinaryOnesAndValue() {
        List<Integer> start = Arrays.asList(6, 7, 1, 16, 2, 20);
        solution.sortByBinaryOnesAndValue(start);
        List<Integer> res = List.of(1, 2, 16, 6, 20, 7);
        assertEquals(res, start);
    }

}
