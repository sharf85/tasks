package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GcdTest {
    Gcd gcd = new Gcd();

    @Test
    public void testGcd_1and1_1() {
        assertEquals(1, gcd.countGcd(1, 1));
    }

    @Test
    public void testGcd_1and8_1() {
        assertEquals(1, gcd.countGcd(1, 8));
        assertEquals(1, gcd.countGcd(8, 1));
    }

    @Test
    public void testGcd_27and8_1() {
        assertEquals(1, gcd.countGcd(27, 8));
        assertEquals(1, gcd.countGcd(8, 27));
    }

    @Test
    public void testGcd_12and8_4() {
        assertEquals(4, gcd.countGcd(12, 8));
        assertEquals(4, gcd.countGcd(8, 12));
    }

    @Test
    public void testGcd_24and15_3() {
        assertEquals(3, gcd.countGcd(24, 15));
        assertEquals(3, gcd.countGcd(15, 24));
    }

    @Test
    public void testGcd_18and42_6() {
        assertEquals(6, gcd.countGcd(18, 42));
        assertEquals(6, gcd.countGcd(42, 18));
    }
}
