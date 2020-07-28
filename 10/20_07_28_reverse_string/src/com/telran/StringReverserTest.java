package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReverserTest {

    StringReverser stringReverser = new StringReverser();

    @Test
    public void testReverse_emptyString_same() {
        assertEquals("", stringReverser.reverse(""));
    }

    @Test
    public void testReverse_severalDifferentLettersAndChars_reversed() {
        assertEquals("Hell*oWor d", stringReverser.reverse("d roWo*lleH"));
    }
}
