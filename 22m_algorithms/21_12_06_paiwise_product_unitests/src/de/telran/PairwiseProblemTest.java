package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PairwiseProblemTest {

    PairwiseProblem pp = new PairwiseProblem();

    @Test
    public void testSolve_twoElements1and2_2() {
        int[] array = {1, 2};

        assertEquals(2, pp.solve(array));
    }

    @Test
    public void testSolve_threeElements() {
        int[] array = {1, 10, 2};

        assertEquals(20, pp.solve(array));
    }

    @Test
    public void testSolve_twoLargeElements() {
        int[] array = {100_000, 100_000};

        assertEquals(10_000_000_000L, pp.solve(array));
    }

    @Test
    public void testSolve_twoNumbersWithZero() {
        int[] array = {0, 100_000};

        assertEquals(0, pp.solve(array));
    }

    @Test
    public void testSolve_performanceTest() {
        int[] array = new int[100000];
        Random rnd = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(Integer.MAX_VALUE);
        }

        long currentTime = System.currentTimeMillis();
        pp.solve(array);
        System.out.println(System.currentTimeMillis() - currentTime);
    }
}
