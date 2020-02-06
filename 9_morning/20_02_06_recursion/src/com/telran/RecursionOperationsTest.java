package com.telran;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecursionOperationsTest {

    RecursionOperations ro = new RecursionOperations();

    @Test
    public void testPowerRecursion_2into3() {
        assertEquals(8, ro.powerRecursion(2, 3));
    }

    @Test
    public void testPowerRecursion_2into0() {
        assertEquals(1, ro.powerRecursion(2, 0));
    }

    @Test
    public void testPowerRecursion_9into3() {
        assertEquals(729, ro.powerRecursion(9, 3));
    }

    @Test
    public void testSquareRecursion_2into2() {
        assertEquals(4, ro.squareRecursion(2));
    }

    @Test
    public void testSquareRecursion_0into2() {
        assertEquals(0, ro.squareRecursion(0));
    }

    @Test
    public void testSquareRecursion_1into2() {
        assertEquals(1, ro.squareRecursion(1));
    }

    @Test
    public void testSquareRecursion_10into2() {
        assertEquals(100, ro.squareRecursion(10));
    }
}