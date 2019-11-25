package com.telran.collection;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedNumbersListTest {

    private SortedNumbersList list;
    private int[] array;

    @Before
    public void init() {
        array = new int[]{19, 8, -6, 34};
        list = new SortedNumbersList(array);
    }

    @Test
    public void testSize_nonEmpty_correct() {
        assertEquals(4, list.size());
    }

    @Test
    public void testSize_empty_correct() {
        list = new SortedNumbersList(new int[]{});
        assertEquals(0, list.size());
    }

    @Test
    public void testGet_allElements() {
        assertEquals(-6, list.get(0));
        assertEquals(8, list.get(1));
        assertEquals(19, list.get(2));
        assertEquals(34, list.get(3));
    }

    @Test
    public void testContains_all4existingElements_true() {
        assertTrue(list.contains(-6));
        assertTrue(list.contains(8));
        assertTrue(list.contains(19));
        assertTrue(list.contains(34));
    }

    @Test
    public void testContains_noElementsInList_false() {
        assertFalse(list.contains(-5));
        assertFalse(list.contains(9));
        assertFalse(list.contains(25));
    }

    @Test
    public void testRemoveRepeated_severalRepeatedElements_removed() {
        list = new SortedNumbersList(new int[]{1, 1, 1, 2, 2, 2, 3, 3});
        list.removeRepeated();
        array = new int[]{1, 2, 3};
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testRemoveRepeated_severalUnrepeatedElements_non_removed() {
        list = new SortedNumbersList(new int[]{1, 3, 2, -8, 10});
        list.removeRepeated();
        assertEquals(5, list.size());
        assertEquals(-8, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(10, list.get(4));
    }

    @Test
    public void testAdd_nonEmpty_last() {
        list.add(999);
        assertEquals(999, list.get(4));
    }

    @Test
    public void testAdd_nonEmpty_middle() {
        list.add(1);
        assertEquals(1, list.get(1));
    }

    @Test
    public void testAdd_nonEmpty_first() {
        list.add(-7);
        assertEquals(-7, list.get(0));
    }

    @Test
    public void testUnion_differentUnrepeatedLists_correct() {
        SortedNumbersList list1 = new SortedNumbersList(new int[]{1, 2, 3, 4, 5});
        SortedNumbersList list2 = new SortedNumbersList(new int[]{7, 6, -1});
        SortedNumbersList list3 = list1.union(list2);
        SortedNumbersList list4 = list2.union(list1);

        int[] correctArray = {-1, 1, 2, 3, 4, 5, 6, 7};

        for (int i = 0; i < correctArray.length; i++) {
            assertEquals(correctArray[i], list3.get(i));
            assertEquals(correctArray[i], list4.get(i));
        }
    }

    @Test
    public void testUnion_unrepeatedLists_correct() {
        SortedNumbersList list1 = new SortedNumbersList(new int[]{1, 2, 3, 4, 5});
        SortedNumbersList list2 = new SortedNumbersList(new int[]{7, 6, -1, 3, 2});
        SortedNumbersList list3 = list1.union(list2);
        SortedNumbersList list4 = list2.union(list1);

        int[] correctArray = {-1, 1, 2, 3, 4, 5, 6, 7};

        for (int i = 0; i < correctArray.length; i++) {
            assertEquals(correctArray[i], list3.get(i));
            assertEquals(correctArray[i], list4.get(i));
        }
    }

    @Test
    public void testUnion_differentLists_correct() {
        SortedNumbersList list1 = new SortedNumbersList(new int[]{1, 2, 3, 4, 5, 3, 5});
        SortedNumbersList list2 = new SortedNumbersList(new int[]{7, 6, -1, -1, 6});
        SortedNumbersList list3 = list1.union(list2);
        SortedNumbersList list4 = list2.union(list1);

        int[] correctArray = {-1, 1, 2, 3, 4, 5, 6, 7};

        for (int i = 0; i < correctArray.length; i++) {
            assertEquals(correctArray[i], list3.get(i));
            assertEquals(correctArray[i], list4.get(i));
        }
    }

    @Test
    public void testUnion_mixedLists_correct() {
        SortedNumbersList list1 = new SortedNumbersList(new int[]{1, 2, 3, 4, -1, 5, 3, 5, -1});
        SortedNumbersList list2 = new SortedNumbersList(new int[]{7, 6, -1, -1, 6, 5, 2, 3, 5});
        SortedNumbersList list3 = list1.union(list2);
        SortedNumbersList list4 = list2.union(list1);

        int[] correctArray = {-1, 1, 2, 3, 4, 5, 6, 7};

        for (int i = 0; i < correctArray.length; i++) {
            assertEquals(correctArray[i], list3.get(i));
            assertEquals(correctArray[i], list4.get(i));
        }
    }
}
