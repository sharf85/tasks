package de.telran;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

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
}
