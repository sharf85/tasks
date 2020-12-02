package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        int[] numbers = {1, 3, 1};

        assertEquals(3, solution.solve(numbers));
    }

    @Test
    public void test2() {
        int[] numbers = {1, 3, 1, 1, 3};

        assertEquals(1, solution.solve(numbers));
    }

    @Test
    public void test3() {
        int[] numbers = {1, 3, 1, 1, 1};

        assertEquals(3, solution.solve(numbers));
    }

    @Test
    public void test4() {
        int[] numbers = {1, 3, 1, 5, 7, -10, -15, 1, 1, 5, -10, 5, -15, -13, 5, 7, 3};

        assertEquals(-13, solution.solve(numbers));
    }

}
