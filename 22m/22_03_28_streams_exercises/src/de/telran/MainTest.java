package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main = new Main();

    @Test
    public void testIsPrime_negativeNumber_false() {
        assertFalse(main.isPrime(-6));
    }

    @Test
    public void testIsPrime_zero_false() {
        assertFalse(main.isPrime(0));
    }

    @Test
    public void testIsPrime_1_false() {
        assertFalse(main.isPrime(1));
    }

    @Test
    public void testIsPrime_2_true() {
        assertTrue(main.isPrime(2));
    }

    @Test
    public void testIsPrime_3_true() {
        assertTrue(main.isPrime(3));
    }

    @Test
    public void testIsPrime_4_false() {
        assertFalse(main.isPrime(4));
    }

    @Test
    public void testIsPrime_239_true() {
        assertTrue(main.isPrime(239));
    }

    @Test
    public void testIsPrime_236_false() {
        assertFalse(main.isPrime(236));
    }

    @Test
    public void testCombine() {
        IntStream s1 = IntStream.of(1, 60, 2, 45, 4, 5, 6, 15, 30);
        IntStream s2 = IntStream.of(2, 5, 4, 15, 8, 10, 9);

        IntStream res = main.combine(s1, s2);

        List<Integer> expected = Arrays.asList(30, 45, 60);
        // IntStream -> Stream<Integer>
        assertEquals(expected, res.boxed().collect(Collectors.toList()));
    }

    @Test
    public void testFactorial_1() {
        assertEquals(1, main.factorial(1));
    }

    @Test
    public void testFactorial_2() {
        assertEquals(2, main.factorial(2));
    }

    @Test
    public void testFactorial_3() {
        assertEquals(6, main.factorial(3));
    }
}
