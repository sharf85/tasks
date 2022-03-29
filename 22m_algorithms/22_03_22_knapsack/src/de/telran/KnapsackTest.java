package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    Knapsack knapsack = new Knapsack();

    @Test
    void testKnapsack() {
        int V = 2;
        int[] v = {1, 2};
        int[] p = {2, 1};

        int expected = 2;

        assertEquals(expected, knapsack.solveWORepetitions(V, v, p));
    }

    @Test
    void testKnapsack_V0() {
        int V = 0;
        int[] v = {1, 2};
        int[] p = {2, 1};

        int expected = 0;

        assertEquals(expected, knapsack.solveWORepetitions(V, v, p));
    }

    @Test
    void testKnapsack_V4() {
        int V = 4;
        int[] v = {1, 2};
        int[] p = {2, 1};

        int expected = 3;

        assertEquals(expected, knapsack.solveWORepetitions(V, v, p));
    }

    @Test
    void testKnapsack_V4_p0() {
        int V = 4;
        int[] v = {1, 2, 3};
        int[] p = {2, 1, 0};

        int expected = 3;

        assertEquals(expected, knapsack.solveWORepetitions(V, v, p));
    }

    @Test
    void testKnapsack_V400() {
        int V = 400;
        int[] v = {1500, 200, 368};
        int[] p = {276, 1000, 100000};

        int expected = 100000;

        assertEquals(expected, knapsack.solveWORepetitions(V, v, p));
    }

    @Test
    void testKnapsack_V10() {
        int V = 10;
        int[] v = {6, 3, 4, 2};
        int[] p = {30, 14, 16, 9};

        int expected = 46;

        assertEquals(expected, knapsack.solveWORepetitions(V, v, p));
    }

    @Test
    void testSolveWRepetitions_V10() {
        int V = 10;
        int[] v = {6, 3, 4, 2};
        int[] p = {30, 14, 16, 9};

        int expected = 48;

        assertEquals(expected, knapsack.solveWRepetitions(V, v, p));
    }

    @Test
    void testSolveWRepetitionsRecursively_V10() {
        int V = 10;
        int[] v = {6, 3, 4, 2};
        int[] p = {30, 14, 16, 9};

        int expected = 48;

        assertEquals(expected, knapsack.solveWRepetitionsRecursively(V, v, p));
    }
}
