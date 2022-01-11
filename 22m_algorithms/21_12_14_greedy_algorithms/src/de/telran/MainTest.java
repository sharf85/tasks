package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main = new Main();

    @Test
    public void fuelStationsTest900() {

        int[] fuelStations = {200, 375, 550, 750};
        assertEquals(2, main.getFuelingNumber(900, 400, fuelStations));
    }

    @Test
    public void fuelStationsTestDist200() {
        int[] fuelStations = {200, 375, 550, 750};
        assertEquals(4, main.getFuelingNumber(900, 200, fuelStations));
    }

    @Test
    public void testSolve_oneElement_segment5() {
        int[] numbers = {3};
        int res = main.getSegmentNumber(numbers, 5);

        assertEquals(1, res);
    }

    @Test
    public void testSolve_severalElements_segment1() {
        int[] numbers = {3, 5, 7, 9, 14};
        int res = main.getSegmentNumber(numbers, 1);

        assertEquals(5, res);
    }

    @Test
    public void testSolve_severalElements_longSegment() {
        int[] numbers = {3, 5, 7, 9, 14};
        int res = main.getSegmentNumber(numbers, 20);

        assertEquals(1, res);
    }

    @Test
    public void testSolve_severalElements_segment7() {
        int[] numbers = {3, 5, 7, 9, 14};
        int res = main.getSegmentNumber(numbers, 7);

        assertEquals(2, res);
    }

    @Test
    public void test_Solve_sum23() {
        int res = main.exchangeMoney(23);
        assertEquals(5, res);
    }

    @Test
    public void test_Solve_sum17() {
        int res = main.exchangeMoney(17);
        assertEquals(4, res);
    }

    @Test
    public void test_Solve_sum101() {
        int res = main.exchangeMoney(101);
        assertEquals(11, res);
    }

}
