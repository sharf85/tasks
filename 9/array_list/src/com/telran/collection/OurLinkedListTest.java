package com.telran.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class OurLinkedListTest {

    @Test
    public void testAppendGet_emptyObject_addsOneElement() {
        OurLinkedList list = new OurLinkedList();

        list.append(5);

        assertEquals(5, list.get(0));
    }

    @Test
    public void testAppendGet_emptyObject_appendsSeveralElement() {
        OurLinkedList list = new OurLinkedList();

        Integer[] expected = {1, 3, -10, 18, 4, 3, 7, 1, 3, 3, 3, 5, 5, 10, -18, 22, 28, 60, 15, 20};
        for (int i = 0; i < expected.length; i++) {
            list.append(expected[i]);
        }

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
    }

    @Test
    public void testSize_emptyObject_appendsOneElement() {
        OurLinkedList list = new OurLinkedList();

        list.append(5);

        assertEquals(1, list.size());
    }

    @Test
    public void testSize_emptyObject_appendsSeveralElement() {
        OurLinkedList list = new OurLinkedList();

        Integer[] expected = {1, 3, -10, 18, 4, 3, 7, 1, 3, 3, 3, 5, 5, 10, -18, 22, 28, 60, 15, 20};
        for (int i = 0; i < expected.length; i++) {
            list.append(expected[i]);
        }

        assertEquals(expected.length, list.size());
    }

    @Test
    public void testSet_oneElement_swapsElement() {
        OurLinkedList list = new OurLinkedList();
        list.append(0);
        list.set(10, 0);

        assertEquals(10, list.get(0));
    }

    @Test
    public void testSet_severalElement_swapsFirstLastMiddleElements() {
        OurLinkedList list = new OurLinkedList();

        Integer[] source = {1, 3, -10, 18, 4};
        for (int i = 0; i < source.length; i++) {
            list.append(source[i]);
        }

        list.set(10, 0);
        list.set(5, 4);
        list.set(-5, 2);

        Integer[] expected = {10, 3, -5, 18, 5};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_nonEmptyObject_takeOuterElement() {
        OurLinkedList list = new OurLinkedList();

        list.append(5);
        list.append(15);
        list.append(2);
        list.append(5);

        list.get(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet_nonEmptyObject_putOuterElement() {
        OurLinkedList list = new OurLinkedList();

        list.append(5);
        list.append(15);
        list.append(2);
        list.append(5);

        list.set(0, 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveById_nonEmptyObject_removesOuterElement() {
        OurLinkedList list = new OurLinkedList();

        list.append(5);
        list.append(15);
        list.append(2);
        list.append(5);

        list.removeById(4);
    }

    @Test
    public void testRemoveById_nonEmptyObject_removesFirstElement() {
        OurLinkedList list = new OurLinkedList();

        list.append(5);
        list.append(15);
        list.append(2);
        list.append(5);
        list.append(17);
        list.append(20);

        Object object = list.removeById(0);
        assertEquals(5, object);

        Integer[] expected = {15, 2, 5, 17, 20};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removesMiddleElement() {
        OurLinkedList list = new OurLinkedList();

        list.append(5);
        list.append(15);
        list.append(2);
        list.append(5);
        list.append(17);
        list.append(20);

        Object object = list.removeById(2);
        assertEquals(2, object);

        Integer[] expected = {5, 15, 5, 17, 20};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removesLastElement() {
        OurLinkedList list = new OurLinkedList();

        list.append(5);
        list.append(15);
        list.append(2);
        list.append(5);
        list.append(17);
        list.append(20);

        Object object = list.removeById(5);
        assertEquals(20, object);

        Integer[] expected = {5, 15, 2, 5, 17};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
    }

    @Test
    public void testRemove_nonEmptyObject_removesLastElement() {
        OurLinkedList list = new OurLinkedList();

        list.append(5);
        list.append(15);
        list.append(2);
        list.append(5);
        list.append(17);
        list.append(20);

        boolean removed = list.remove(20);
        assertTrue(removed);

        Integer[] expected = {5, 15, 2, 5, 17};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
    }

    @Test
    public void testRemove_nonEmptyObject_removesFirstElement() {
        OurLinkedList list = new OurLinkedList();

        list.append(5);
        list.append(15);
        list.append(2);
        list.append(5);
        list.append(17);
        list.append(20);

        boolean removed = list.remove(5);
        assertTrue(removed);

        Integer[] expected = {15, 2, 5, 17, 20};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
    }

    @Test
    public void testRemove_nonEmptyObject_removesMiddleElement() {
        OurLinkedList list = new OurLinkedList();

        list.append(5);
        list.append(15);
        list.append(2);
        list.append(5);
        list.append(17);
        list.append(20);

        boolean removed = list.remove(2);
        assertTrue(removed);

        Integer[] expected = {5, 15, 5, 17, 20};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
    }

    @Test
    public void testContains_nonEmptyObject_containsElements() {
        OurLinkedList list = new OurLinkedList();

        list.append(5);
        list.append(15);
        list.append(2);
        list.append(5);
        list.append(17);
        list.append(20);

        assertTrue(list.contains(5));
        assertTrue(list.contains(17));
        assertTrue(list.contains(20));
    }

    @Test
    public void testContains_nonEmptyObject_notContainsElements() {
        OurLinkedList list = new OurLinkedList();

        list.append(5);
        list.append(15);
        list.append(2);
        list.append(5);
        list.append(17);
        list.append(20);

        assertFalse(list.contains(1));
        assertFalse(list.contains(16));
        assertFalse(list.contains(24));
    }

    @Test
    public void testContains_emptyObject_notContainsElements() {
        OurLinkedList list = new OurLinkedList();

        assertFalse(list.contains(1));
        assertFalse(list.contains(16));
        assertFalse(list.contains(24));
    }

    @Test
    public void testRemove_emptyObject_notContainsElements() {
        OurLinkedList list = new OurLinkedList();

        assertFalse(list.remove(4));
    }


}