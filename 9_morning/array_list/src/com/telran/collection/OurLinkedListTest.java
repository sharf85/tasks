package com.telran.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class OurLinkedListTest {
    @Test
    public void testSize_emptyObject_returns0() {
        OurLinkedList list = new OurLinkedList();
        assertEquals(0, list.size());
    }

    @Test
    public void testSize_nonEmptyObject_returnsSize() {
        int[] source = {1, 2, 3};
        OurLinkedList list = new OurLinkedList();

        for (int num : source) {
            list.append(num);
        }

        assertEquals(source.length, list.size());
    }

    @Test
    public void testGet_nonEmptyObjectFromArray_getsAllElements() {
        int[] source = {1, 2, -6, 0, 5, 3};
        OurLinkedList list = new OurLinkedList();

        for (int num : source) {
            list.append(num);
        }

        for (int i = 0; i < source.length; i++) {
            assertEquals(source[i], list.get(i));
        }

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_nonEmptyObjectGetNegative_throwsIndexOutOfBoundsException() {
        int[] source = {1, 2, -6, 0, 5, 3};
        OurLinkedList list = new OurLinkedList();

        for (int num : source) {
            list.append(num);
        }

        list.get(-1);
    }

    @Test
    public void testRemoveById_nonEmptyObject_RemovesElementsFromBeginning() {
        int[] source = {1, 2, 5, 7};
        OurLinkedList list = new OurLinkedList();

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
        OurLinkedList list = new OurLinkedList();

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
        OurLinkedList list = new OurLinkedList();

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
        OurLinkedList list = new OurLinkedList();

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
        OurLinkedList list = new OurLinkedList();

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
        OurLinkedList list = new OurLinkedList();

        assertFalse(list.contains(-1));
        assertFalse(list.contains(6));
        assertFalse(list.contains(3));
        assertFalse(list.contains(8));
    }

    @Test
    public void testRemove_emptyArray_notContains() {
        OurLinkedList list = new OurLinkedList();

        assertFalse(list.remove(-1));
        assertFalse(list.remove(6));
        assertFalse(list.remove(3));
        assertFalse(list.remove(8));

        assertEquals(0, list.size());
    }

    @Test
    public void testRemove_nonEmptyArray_removesFirst() {
        int[] source = {1, 2, 5, 7};
        OurLinkedList list = new OurLinkedList();

        for (int i : source) {
            list.append(i);
        }

        assertTrue(list.remove(1));

        int[] expected = {2, 5, 7};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(3, list.size());
    }

    @Test
    public void testRemove_nonEmptyArray_removesLast() {
        int[] source = {1, 2, 5, 7};
        OurLinkedList list = new OurLinkedList();

        for (int i : source) {
            list.append(i);
        }

        assertTrue(list.remove(7));

        int[] expected = {1, 2, 5};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(3, list.size());
    }

    @Test
    public void testRemove_nonEmptyArray_removesMiddle() {
        int[] source = {1, 2, 5, 7};
        OurLinkedList list = new OurLinkedList();

        for (int i : source) {
            list.append(i);
        }

        assertTrue(list.remove(5));

        int[] expected = {1, 2, 7};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(3, list.size());
    }

}