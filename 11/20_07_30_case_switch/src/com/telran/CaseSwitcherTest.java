package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaseSwitcherTest {

    CaseSwitcher switcher = new CaseSwitcher();

    @Test
    public void testSwap_emptyString_emptyString() {
        assertEquals("", switcher.swap(""));
    }

    @Test
    public void testSwap_nonLetterChars_nothingHappened() {
        assertEquals("*&- _@4", switcher.swap("*&- _@4"));
    }

    @Test
    public void testSwap_oneSmallLetter_swapped() {
        assertEquals("G", switcher.swap("g"));
    }

    @Test
    public void testSwap_oneCapitalLetter_swapped() {
        assertEquals("h", switcher.swap("H"));
    }

    @Test
    public void testSwap_mixedString_swapped() {
        assertEquals("Hel+L 1o", switcher.swap("hEL+l 1O"));
    }
}
