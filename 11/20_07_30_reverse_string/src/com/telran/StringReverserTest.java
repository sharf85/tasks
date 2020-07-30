package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReverserTest {
    StringReverser reverser = new StringReverser();

    @Test
    public void testReverse_emptyString_againEmptyString() {
        assertEquals("", reverser.reverse(""));
    }

    @Test
    public void testReverse_evenNumOfLetter_reverser() {
        assertEquals("dcba", reverser.reverse("abcd"));
    }

    @Test
    public void testReverse_oddNumOfLetter_reverser() {
        assertEquals("cba", reverser.reverse("abc"));
    }

    @Test
    public void testReverse_mixedString_reverser() {
        assertEquals("H@\nel-loK", reverser.reverse("Kol-le\n@H"));
    }
}
