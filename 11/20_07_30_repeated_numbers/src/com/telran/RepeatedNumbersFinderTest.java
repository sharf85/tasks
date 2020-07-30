package com.telran;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedNumbersFinderTest {

    RepeatedNumbersFinder numbersFinder = new RepeatedNumbersFinder();

    @Test
    public void testGetRepeated_emptyList_emptyList() {
        List<Integer> expected = new ArrayList<>();
        List<Integer> toTest = new ArrayList<>();
        assertEquals(expected, numbersFinder.getRepeated(toTest));
    }

    @Test
    public void testGetRepeated_oneElement_emptyList() {
        List<Integer> expected = new ArrayList<>();
        List<Integer> toTest = Arrays.asList(1);
        assertEquals(expected, numbersFinder.getRepeated(toTest));
    }

    @Test
    public void testGetRepeated_oneUniqElt2occurrences_oneElement() {
        List<Integer> expected = Arrays.asList(4);
        List<Integer> toTest = Arrays.asList(4, 4);
        assertEquals(expected, numbersFinder.getRepeated(toTest));
    }

    @Test
    public void testGetRepeated_oneUniqElt4occurrences_oneElement() {
        List<Integer> expected = Arrays.asList(4);
        List<Integer> toTest = Arrays.asList(4, 4, 4, 4);
        assertEquals(expected, numbersFinder.getRepeated(toTest));
    }

    @Test
    public void testGetRepeated_severalUniqElements_emptyList() {
        List<Integer> expected = new ArrayList<>();
        List<Integer> toTest = Arrays.asList(4, -10, 5, 1);
        assertEquals(expected, numbersFinder.getRepeated(toTest));
    }

    @Test
    public void testGetRepeated_mixedList_severalElements() {
        Set<Integer> expected = new HashSet<>(Arrays.asList(5, 4));
        List<Integer> toTest = Arrays.asList(4, -10, 5, 4, 1, 5, 4, 8, 17);

        Set<Integer> resultToCompare = new HashSet<>(numbersFinder.getRepeated(toTest));
        assertEquals(expected, resultToCompare);
    }
}
