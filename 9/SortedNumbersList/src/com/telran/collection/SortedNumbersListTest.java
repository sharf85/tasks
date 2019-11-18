package com.telran.collection;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedNumbersListTest {

    SortedNumbersList list;
    int[] array;

    @Before
    public void init() {
        array = new int[]{19, 8, -6, 34};
        list = new SortedNumbersList(array);
    }

    @Test
    public void testSize() {
        assertEquals(4, list.size());
    }

    @Test
    public void testGet_allElements() {
        assertEquals(-6, list.get(0));
        assertEquals(8, list.get(1));
        assertEquals(19, list.get(2));
        assertEquals(34, list.get(3));
    }

    @Test
    public void testContains_true() {
        assertTrue(list.contains(-6));
        assertTrue(list.contains(8));
        assertTrue(list.contains(19));
        assertTrue(list.contains(34));
    }

    @Test
    public void testContains_false() {
        assertFalse(list.contains(-5));
        assertFalse(list.contains(9));
        assertFalse(list.contains(25));
    }
}
