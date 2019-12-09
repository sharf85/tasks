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

}