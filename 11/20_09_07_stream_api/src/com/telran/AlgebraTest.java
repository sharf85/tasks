package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgebraTest {

    Algebra algebra = new Algebra();

    @Test
    public void testIsPrime_2_prime() {
        assertTrue(algebra.isPrime(2));
    }

    @Test
    public void testIsPrime_3_prime() {
        assertTrue(algebra.isPrime(3));
    }

    @Test
    public void testIsPrime_5_prime() {
        assertTrue(algebra.isPrime(5));
    }

    @Test
    public void testIsPrime_29_prime() {
        assertTrue(algebra.isPrime(29));
    }

    @Test
    public void testIsPrime_101_prime() {
        assertTrue(algebra.isPrime(101));
    }

    @Test
    public void testIsPrime_200_notPrime() {
        assertFalse(algebra.isPrime(200));
    }

    @Test
    public void testIsPrime_400_notPrime() {
        assertFalse(algebra.isPrime(400));
    }

    @Test
    public void testIsPrime_961_notPrime() {
        assertFalse(algebra.isPrime(961));
    }


    @Test
    public void testFactorial_1_1() {
        assertEquals(1, algebra.factorial(1));
    }

    @Test
    public void testFactorial_2_2() {
        assertEquals(2, algebra.factorial(2));
    }

    @Test
    public void testFactorial_3_6() {
        assertEquals(6, algebra.factorial(3));
    }

    @Test
    public void testFactorial_4_24() {
        assertEquals(24, algebra.factorial(4));
    }

    @Test
    public void testFactorial_5_120() {
        assertEquals(120, algebra.factorial(5));
    }

    @Test
    public void testSumOdds_4And4_0() {
        assertEquals(0, algebra.sumOds(4, 4));
    }

    @Test
    public void testSumOdds_5And5_5() {
        assertEquals(5, algebra.sumOds(5, 5));
    }

    @Test
    public void testSumOdds_5And6_5() {
        assertEquals(5, algebra.sumOds(5, 6));
    }

    @Test
    public void testSumOdds_5And7_12() {
        assertEquals(12, algebra.sumOds(5, 7));
    }

    @Test
    public void testSumOdds_6And8_7() {
        assertEquals(7, algebra.sumOds(6, 8));
    }

    @Test
    public void testSumOdds_64And128_3072() {
        assertEquals(3072, algebra.sumOds(64, 128));
    }
}
