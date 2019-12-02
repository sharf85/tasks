package com.telran.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortedNumbersListTest {

    @Test
    public void testSize_emptyObject_returns0() {
        SortedNumbersList list = new SortedNumbersList();
        assertEquals(0, list.size());
    }

    @Test
    public void testSize_nonEmptyObject_returnsSize() {
        int[] source = {1, 2, 3};
        SortedNumbersList list = new SortedNumbersList(source);
        assertEquals(source.length, list.size());
    }

    @Test
    public void testGet_nonEmptyObjectFromSortedArray_getsAllElements() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);

        for (int i = 0; i < source.length; i++) {
            assertEquals(source[i], list.get(i));
        }
//        assertEquals(1, list.get(0));
//        assertEquals(2, list.get(1));
//        assertEquals(5, list.get(2));
//        assertEquals(7, list.get(3));
    }

    @Test
    public void testGet_nonEmptyObjectFromNonSortedArray_getsAllElements() {
        int[] source = {1, 2, -6, 0, 5, 3};
        SortedNumbersList list = new SortedNumbersList(source);

        int[] expected = {-6, 0, 1, 2, 3, 5};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
//        assertEquals(-6, list.get(0));
//        assertEquals(0, list.get(1));
//        assertEquals(1, list.get(2));
//        assertEquals(2, list.get(3));
//        assertEquals(3, list.get(4));
//        assertEquals(5, list.get(5));
    }

    @Test
    public void testAdd_nonEmptyObject_AddsElementsToMiddle() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);

        list.add(4);
        list.add(2);

        int[] expected = {1, 2, 2, 4, 5, 7};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(6, list.size());
    }

    @Test
    public void testAdd_nonEmptyObject_AddsElementsToEnd() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);

        list.add(7);
        list.add(8);

        int[] expected = {1, 2, 5, 7, 7, 8};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(6, list.size());
    }

    @Test
    public void testAdd_nonEmptyObject_AddsElementsToBeginning() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);

        list.add(1);
        list.add(-6);

        int[] expected = {-6, 1, 1, 2, 5, 7};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(6, list.size());
    }

    @Test
    public void testAdd_emptyObject_AddsElementsToMiddle() {
        SortedNumbersList list = new SortedNumbersList();

        list.add(2);
        assertEquals(2, list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_RemovesElementsFromBeginning() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);

        list.removeById(0);

        int[] expected = {2, 5, 7};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_RemovesElementsFromEnd() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);

        list.removeById(3);

        int[] expected = {1, 2, 5};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_RemovesElementsFromMiddle() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);

        list.removeById(2);

        int[] expected = {1, 2, 7};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(3, list.size());
    }

}