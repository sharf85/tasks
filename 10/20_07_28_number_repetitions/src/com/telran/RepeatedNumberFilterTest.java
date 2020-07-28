package com.telran;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedNumberFilterTest {
    RepeatedNumberFilter filter = new RepeatedNumberFilter();

    @Test
    public void testRemoveRepeated_emptyList_emptyList() {
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, filter.remainRepeated(new ArrayList<>()));
    }

    @Test
    public void testRemoveRepeated_severalNumsNoRepetitions_emptyList() {
        List<Integer> expected = new ArrayList<>();
        List<Integer> toTest = Arrays.asList(8, -10, 4, 15);
        assertEquals(expected, filter.remainRepeated(toTest));
    }

    @Test
    public void testRemoveRepeated_severalNumsOneNum2ccurrences_singleNumberList() {
        List<Integer> expected = Arrays.asList(-10);
        List<Integer> toTest = Arrays.asList(8, -10, 4, 15, -10);
        assertEquals(expected, filter.remainRepeated(toTest));
    }

    @Test
    public void testRemoveRepeated_severalNumsOneNum3ccurrences_singleNumberList() {
        List<Integer> expected = Arrays.asList(-10);
        List<Integer> toTest = Arrays.asList(8, -10, 4, -10, 15, -10);
        assertEquals(expected, filter.remainRepeated(toTest));
    }

    @Test
    public void testRemoveRepeated_severalNumsOneNum3ccurrencesAndOneNum3Occurences_twoNumberList() {
        Set<Integer> expected = new HashSet<>(Arrays.asList(-10, 4));
        List<Integer> toTest = Arrays.asList(8, -10, 4, -10, 15, -10, 1, 4, 9, 4);
        assertEquals(expected, new HashSet<>(filter.remainRepeated(toTest)));
    }
}
