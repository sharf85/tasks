package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntServiceTest {
    IntService intService = new IntService();

    @Test
    public void isPrime_true_test() {

        assertTrue(intService.isPrime(5));
        assertTrue(intService.isPrime(7));
        assertTrue(intService.isPrime(11));
    }

    @Test
    public void isPrime_1_false() {
        assertFalse(intService.isPrime(1));
    }

    @Test
    public void isPrime_false_test() {

        assertFalse(intService.isPrime(6));
        assertFalse(intService.isPrime(8));
        assertFalse(intService.isPrime(40));
    }

    @Test
    public void isPrime_squareNumber9_false() {
        assertFalse(intService.isPrime(9));
        assertFalse(intService.isPrime(4));
    }
}
