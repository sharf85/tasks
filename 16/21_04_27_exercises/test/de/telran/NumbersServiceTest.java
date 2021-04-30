package de.telran;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NumbersServiceTest {

    NumbersService numbersService = new NumbersService();

    @Test
    public void testGetNumberOfMaxOccurrence_emptyList_throwsNoSuchElementException() {
        List<Integer> emptyList = new ArrayList<>();
        assertThrows(NoSuchElementException.class,
                () -> numbersService.getNumberOfMaxOccurrence(emptyList));
    }

    @Test
    public void testGetNumberOfMaxOccurrence_oneNumber() {
        List<Integer> argument = Arrays.asList(2);
        assertEquals(2, numbersService.getNumberOfMaxOccurrence(argument));
    }

    @Test
    public void testGetNumberOfMaxOccurrence_severalDifferentNumbers_any() {
        List<Integer> argument = Arrays.asList(2, 8, -10);
        int res = numbersService.getNumberOfMaxOccurrence(argument);
        assertTrue(2 == res || 8 == res || -10 == res);
    }

    @Test
    public void testGetNumberOfMaxOccurrence_severalNumbersSeveralTimes_any() {
        List<Integer> argument = Arrays.asList(2, 8, -10, 8, -10, 3);
        int res = numbersService.getNumberOfMaxOccurrence(argument);
        assertTrue(8 == res || -10 == res);
    }

    @Test
    public void testGetNumberOfMaxOccurrence_preciselyDefinedNumber() {
        List<Integer> argument = Arrays.asList(2, 8, -10, 8, -10, 2, 5, 3, 2);
        int res = numbersService.getNumberOfMaxOccurrence(argument);
        assertEquals(2, res);
    }

    @Test
    public void testIsPrime_1() {
        assertFalse(numbersService.isPrime(1));
    }

    @Test
    public void testIsPrime_2() {
        assertTrue(numbersService.isPrime(2));
    }

    @Test
    public void testIsPrime_3() {
        assertTrue(numbersService.isPrime(3));
    }

    @Test
    public void testIsPrime_4() {
        assertFalse(numbersService.isPrime(4));
    }

    @Test
    public void testIsPrime_239() {
        assertTrue(numbersService.isPrime(239));
    }

    @Test
    public void testIsPrime_10() {
        assertFalse(numbersService.isPrime(10));
    }

    @Test
    public void testGetAllPrimesTo_1() {
        List<Integer> res = numbersService.getAllPrimesTo(1);
        assertTrue(res.isEmpty());
    }

    @Test
    public void testGetAllPrimesTo_2() {
        List<Integer> res = numbersService.getAllPrimesTo(2);
        List<Integer> expected = Arrays.asList(2);
        assertEquals(expected, res);
    }

    @Test
    public void testGetAllPrimesTo_3() {
        List<Integer> res = numbersService.getAllPrimesTo(3);
        List<Integer> expected = Arrays.asList(2, 3);
        assertEquals(expected, res);
    }

    @Test
    public void testGetAllPrimesTo_4() {
        List<Integer> res = numbersService.getAllPrimesTo(10);
        List<Integer> expected = Arrays.asList(2, 3, 5, 7);
        assertEquals(expected, res);

    }

    @Test
    public void testGetMaxCoveredNumbers_generalCase() {
        List<Integer> numbers = Arrays.asList(5, 1, -10, -8, 4, 3);
        assertEquals(3, numbersService.getMaxCoveredNumbers(numbers, 2));
        assertEquals(2, numbersService.getMaxCoveredNumbers(numbers, 1));
        assertEquals(4, numbersService.getMaxCoveredNumbers(numbers, 4));
    }
}
