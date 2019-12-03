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

        int deleted = list.removeById(0);
        assertEquals(1, deleted);

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

        int deleted = list.removeById(3);
        assertEquals(7, deleted);

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

        int deleted = list.removeById(2);
        assertEquals(5, deleted);

        int[] expected = {1, 2, 7};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(3, list.size());
    }

    @Test
    public void testContains_nonEmptyArray_containsFirstMiddleLastElements() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);

        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(5));
        assertTrue(list.contains(7));
    }

    @Test
    public void testContains_nonEmptyArray_notContains() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);

        assertFalse(list.contains(-1));
        assertFalse(list.contains(6));
        assertFalse(list.contains(3));
        assertFalse(list.contains(8));
    }

    @Test
    public void testUnion_emptyListAndEmptyList_yieldsEmptyList() {
        SortedNumbersList list = new SortedNumbersList();
        SortedNumbersList anotherList = new SortedNumbersList();
        SortedNumbersList union = list.union(anotherList);

        assertEquals(0, union.size());
    }

    @Test
    public void testUnion_emptyListAndNonEmptyList_yieldsSecondList() {
        SortedNumbersList list = new SortedNumbersList();

        int[] source = new int[]{1, 3, 4, 7};
        SortedNumbersList anotherList = new SortedNumbersList(source);
        SortedNumbersList union = list.union(anotherList);

        for (int i = 0; i < source.length; i++) {
            assertEquals(source[i], union.get(i));
        }
        assertEquals(4, union.size());
    }

    @Test
    public void testUnion_nonEmptyListAndEmptyList_yieldsFirstList() {
        int[] source = new int[]{1, 3, 4, 7};
        SortedNumbersList list = new SortedNumbersList(source);
        SortedNumbersList anotherList = new SortedNumbersList();
        SortedNumbersList union = list.union(anotherList);

        for (int i = 0; i < source.length; i++) {
            assertEquals(source[i], union.get(i));
        }
        assertEquals(4, union.size());
    }

    @Test
    public void testUnion_twoNonEmptyLists_noIntersections() {
        int[] source = new int[]{1, 3, 4, 7};
        SortedNumbersList list = new SortedNumbersList(source);

        int[] source2 = new int[]{2, 8, 15};
        SortedNumbersList anotherList = new SortedNumbersList(source2);
        SortedNumbersList union = list.union(anotherList);

        int[] expected = {1, 2, 3, 4, 7, 8, 15};
        for (int i = 0; i < source.length; i++) {
            assertEquals(expected[i], union.get(i));
        }
        assertEquals(7, union.size());
    }

    @Test
    public void testUnion_twoNonEmptyLists_withIntersections() {
        int[] source = new int[]{1, 3, 2, 4, 7};
        SortedNumbersList list = new SortedNumbersList(source);

        int[] source2 = new int[]{2, 8, 4, 7, 15};
        SortedNumbersList anotherList = new SortedNumbersList(source2);
        SortedNumbersList union = list.union(anotherList);

        int[] expected = {1, 2, 3, 4, 7, 8, 15};
        for (int i = 0; i < source.length; i++) {
            assertEquals(expected[i], union.get(i));
        }
        assertEquals(7, union.size());
    }

    @Test
    public void testIntersection_twoNonEmptyLists_noIntersections() {
        int[] source = new int[]{1, 2, 3};
        SortedNumbersList list = new SortedNumbersList(source);

        int[] source2 = new int[]{4, -1, 6};
        SortedNumbersList anotherList = new SortedNumbersList(source2);
        SortedNumbersList intersection = list.intersection(anotherList);

        assertEquals(0, intersection.size());
    }

    @Test
    public void testIntersection_twoNonEmptyLists_withIntersections() {
        int[] source = new int[]{1, 2, 3};
        SortedNumbersList list = new SortedNumbersList(source);

        int[] source2 = new int[]{2, 5, 1, 8};
        SortedNumbersList anotherList = new SortedNumbersList(source2);
        SortedNumbersList intersection = list.intersection(anotherList);

        assertEquals(1, intersection.get(0));
        assertEquals(2, intersection.get(1));

        assertEquals(2, intersection.size());
    }

    @Test
    public void testIntersection_twoNonEmptyListsWithRepetitions_withIntersections() {
        int[] source = new int[]{1, 1, 2, 2, 3};
        SortedNumbersList list = new SortedNumbersList(source);

        int[] source2 = new int[]{2, 5, 5, 8};
        SortedNumbersList anotherList = new SortedNumbersList(source2);
        SortedNumbersList intersection = list.intersection(anotherList);

        assertEquals(2, intersection.get(0));

        assertEquals(1, intersection.size());
    }

    @Test
    public void testIntersection_emptyAndNonEmptyListWithRepetitions_noIntersections() {
        int[] source = new int[]{};
        SortedNumbersList list = new SortedNumbersList(source);

        int[] source2 = new int[]{2, 5, 5, 8};
        SortedNumbersList anotherList = new SortedNumbersList(source2);
        SortedNumbersList intersection = list.intersection(anotherList);

        assertEquals(0, intersection.size());
    }

    @Test
    public void testIntersection_nonEmptyWithRepetitionsAndEmptyList_noIntersections() {
        int[] source = new int[]{2, 5, 5, 8};
        SortedNumbersList list = new SortedNumbersList(source);

        int[] source2 = new int[]{};
        SortedNumbersList anotherList = new SortedNumbersList(source2);
        SortedNumbersList intersection = list.intersection(anotherList);

        assertEquals(0, intersection.size());
    }

    @Test
    public void testIntersection_twoEmptyLists_noIntersections() {
        int[] source = new int[]{};
        SortedNumbersList list = new SortedNumbersList(source);

        int[] source2 = new int[]{};
        SortedNumbersList anotherList = new SortedNumbersList(source2);
        SortedNumbersList intersection = list.intersection(anotherList);

        assertEquals(0, intersection.size());

        int a = new Integer(1);
        assertEquals(1, a);
    }

}