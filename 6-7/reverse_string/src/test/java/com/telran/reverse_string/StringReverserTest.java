package com.telran.reverse_string;

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
    public void testReverse_EmptyString_EmptyString() {
        assertEquals(stringReverser.reverse(""), "");
    }

    @Test
    public void testReverse_OneWord_reversedOneWord() {
        assertEquals(stringReverser.reverse("String"), "gnirtS");
    }
}
