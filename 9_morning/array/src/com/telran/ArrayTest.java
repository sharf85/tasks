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

}