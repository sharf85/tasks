package com.telran.collection;

import com.telran.comparator.IntComparator;
import com.telran.comparator.OurComparator;
import org.junit.Test;

import static org.junit.Assert.*;

public class OurArrayListTest {

    @Test
    public void testSize_emptyObject_returns0() {
        OurArrayList list = new OurArrayList();
        assertEquals(0, list.size());
    }

    @Test
    public void testSize_nonEmptyObject_returnsSize() {
        int[] source = {1, 2, 3};
        OurArrayList<Integer> list = new OurArrayList<Integer>();

        for (int num : source) {
            list.append(num);
        }

        assertEquals(source.length, list.size());
    }

    @Test
    public void testGet_nonEmptyObjectFromArray_getsAllElements() {
        int[] source = {1, 2, -6, 0, 5, 3};
        OurArrayList<Integer> list = new OurArrayList<>();

        for (int num : source) {
            list.append(num);
        }

        for (int i = 0; i < source.length; i++) {
            assertEquals(source[i], (long) list.get(i));
        }

    }

    @Test
    public void testRemoveById_nonEmptyObject_RemovesElementsFromBeginning() {
        int[] source = {1, 2, 5, 7};
        OurArrayList list = new OurArrayList();

        for (int i : source) {
            list.append(i);
        }

        Object deleted = list.removeById(0);
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
        OurArrayList list = new OurArrayList();

        for (int i : source) {
            list.append(i);
        }

        Object deleted = list.removeById(3);
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
        OurArrayList list = new OurArrayList();

        for (int i : source) {
            list.append(i);
        }

        Object deleted = list.removeById(2);
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
        OurArrayList list = new OurArrayList();

        for (int i : source) {
            list.append(i);
        }

        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(5));
        assertTrue(list.contains(7));
    }

    @Test
    public void testContains_nonEmptyArray_notContains() {
        int[] source = {1, 2, 5, 7};
        OurArrayList list = new OurArrayList();

        for (int i : source) {
            list.append(i);
        }

        assertFalse(list.contains(-1));
        assertFalse(list.contains(6));
        assertFalse(list.contains(3));
        assertFalse(list.contains(8));
    }

    @Test
    public void testContains_emptyArray_notContains() {
        OurArrayList list = new OurArrayList();

        assertFalse(list.contains(-1));
        assertFalse(list.contains(6));
        assertFalse(list.contains(3));
        assertFalse(list.contains(8));
    }

    @Test
    public void testMax_nonEmptyIntegerList() {
        int[] source = {1, 2, 67, 5, 7};
        OurArrayList list = new OurArrayList();

        for (int i : source) {
            list.append(i);
        }

        OurComparator intComparator = new IntComparator();
        assertEquals(67, list.max(intComparator));
    }

    @Test(expected = EmptyListException.class)
    public void testMax_emptyIntegerList_throwsEmptyListException() {
        OurArrayList list = new OurArrayList();
        list.max(new IntComparator());
    }

    @Test
    public void testMin_nonEmptyIntegerList() {
        int[] source = {1, 2, 67, 5, 7};
        OurArrayList list = new OurArrayList();

        for (int i : source) {
            list.append(i);
        }

        OurComparator intComparator = new IntComparator();
        assertEquals(1, list.min(intComparator));
    }

    @Test(expected = EmptyListException.class)
    public void testMin_emptyIntegerList_throwsEmptyListException() {
        OurArrayList list = new OurArrayList();
        OurComparator intComparator = new IntComparator();
        list.min(intComparator);
    }

    @Test
    public void testSort_nonEmptyIntegerList() {
        int[] source = {1, 2, 67, 5, 7};
        OurArrayList list = new OurArrayList();

        for (int i : source) {
            list.append(i);
        }

        OurComparator intComparator = new IntComparator();
        list.sort(intComparator);

        int[] expected = {1, 2, 5, 7, 67};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
    }

}