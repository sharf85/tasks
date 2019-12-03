package com.telran;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayTest {

    @Test
    public void testSize_nonEmptyObject_3elements() {
        Array ourArray = new Array(new int[]{2, -9, -10});
        assertEquals(3, ourArray.size());
    }

    @Test
    public void testSize_emptyObject_0elements() {
        Array ourArray = new Array();
        assertEquals(0, ourArray.size());
    }

    @Test
    public void testGet_NonEmptyArray_AllElementsMatch() {
        Array ourArray = new Array(new int[]{2, -9, -10});
        assertEquals(2, ourArray.get(0));
        assertEquals(-9, ourArray.get(1));
        assertEquals(-10, ourArray.get(2));
    }

    @Test
    public void testAppend_NonEmptyArray_AllElementsMatch() {
        Array ourArray = new Array(new int[]{2, -9, -10});

        ourArray.append(5);//{2, -9, -10, 5}

        int[] expected = {2, -9, -10, 5};

        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

}