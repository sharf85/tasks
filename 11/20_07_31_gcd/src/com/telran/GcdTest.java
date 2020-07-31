package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GcdTest {

    Gcd gcd = new Gcd();

    @Test
    public void testCompute_1and1_1() {
        assertEquals(1, gcd.compute(1, 1));
    }

    @Test
    public void testCompute_1and14_1() {
        assertEquals(1, gcd.compute(1, 14));
        assertEquals(1, gcd.compute(14, 1));
    }

    @Test
    public void testCompute_1and17_1() {
        assertEquals(1, gcd.compute(1, 17));
        assertEquals(1, gcd.compute(17, 1));
    }

    @Test
    public void testCompute_3and12_3() {
        assertEquals(3, gcd.compute(3, 12));
        assertEquals(3, gcd.compute(12, 3));
    }

    @Test
    public void testCompute_72and35_1() {
        assertEquals(1, gcd.compute(72, 35));
        assertEquals(1, gcd.compute(35, 72));
    }

    @Test
    public void testCompute_54and24_6() {
        assertEquals(6, gcd.compute(54, 24));
        assertEquals(6, gcd.compute(24, 54));
    }

    @Test
    public void testCompute_500and600_100() {
        assertEquals(100, gcd.compute(500, 600));
        assertEquals(100, gcd.compute(600, 500));
    }
}
