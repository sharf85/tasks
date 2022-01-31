package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testSolve_() {
        List<Integer> numbers = Arrays.asList(3, 10, 5, 3, 10, 15, 18, 10, 3, 3);
        assertEquals(3, solution.findMaxOccuredElement(numbers));
    }

    @Test
    public void testGetSingleNumber_3numbers2different() {
        List<Integer> ints = Arrays.asList(1, 3, 1);
        assertEquals(3, solution.findSingleNumber(ints));


    }

    @Test
    public void testGetSingleNumber_3numbers3different() {
        List<Integer> ints = Arrays.asList(3, 3, 3);
        assertEquals(3, solution.findSingleNumber(ints));


    }

    @Test
    public void testGetSingleNumber_5numbers() {
        List<Integer> ints = Arrays.asList(-1, -1, 15, -1, -1);
        assertEquals(15, solution.findSingleNumber(ints));


    }

    @Test
    public void testGetSingleNumber_7numbers() {
        List<Integer> ints = Arrays.asList(1, -4, 8, 8, -11, -4, 1);
        assertEquals(-11, solution.findSingleNumber(ints));

    }

    @Test
    public void testGetSingleNumber_9numbers() {
        List<Integer> ints = Arrays.asList(1, 8, 8, 8, 8, 8, 1, 2, 2);
        assertEquals(8, solution.findSingleNumber(ints));

    }
}
