package com.telran;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringReverserTest {

    StringReverser stringReverser;

    @Before
    public void init() {
        stringReverser = new StringReverser();
    }

    @Test
    public void testReverse_emptyString() {
        assertEquals("", stringReverser.reverse(""));
    }

    @Test
    public void testReverse_nonEmptyString() {
        assertEquals("Hello", stringReverser.reverse("olleH"));
    }
}