package com.telran.comparator;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntComparatorTest {

    IntComparator comparator = new IntComparator();

    @Test
    public void testCompare_less() {
        assertTrue(comparator.compare(1, 2) < 0);
        assertTrue(comparator.compare(-1, 2) < 0);
        assertTrue(comparator.compare(-10, -5) < 0);
    }

    @Test
    public void testCompare_greater() {
        assertTrue(comparator.compare(3, 2) > 0);
        assertTrue(comparator.compare(10, 2) > 0);
        assertTrue(comparator.compare(-10, -15) > 0);
    }

    @Test
    public void testCompare_equals() {
        assertEquals(0, comparator.compare(3, 3));
        assertEquals(0, comparator.compare(10, 10));
        assertEquals(0, comparator.compare(-10, -10));
        assertEquals(0, comparator.compare(0, 0));
    }

}