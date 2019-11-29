package com.telran.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class OurArrayListTest {

    @Test
    public void testAddGet_emptyObject_addsOneElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);

        assertEquals(5, list.get(0));
    }

    @Test
    public void testAddGet_emptyObject_addsSeveralElement() {
        OurArrayList list = new OurArrayList();

        Integer[] expected = {1, 3, -10, 18, 4, 3, 7, 1, 3, 3, 3, 5, 5, 10, -18, 22, 28, 60, 15, 20};
        for (int i = 0; i < expected.length; i++) {
            list.add(expected[i]);
        }

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
    }

    @Test
    public void testSize_emptyObject_addsOneElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);

        assertEquals(1, list.size());
    }

    @Test
    public void testSize_emptyObject_addsSeveralElement() {
        OurArrayList list = new OurArrayList();

        Integer[] expected = {1, 3, -10, 18, 4, 3, 7, 1, 3, 3, 3, 5, 5, 10, -18, 22, 28, 60, 15, 20};
        for (int i = 0; i < expected.length; i++) {
            list.add(expected[i]);
        }

        assertEquals(expected.length, list.size());
    }
}