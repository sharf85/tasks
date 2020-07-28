package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterSwitcherTest {

    RegisterSwitcher registerSwitcher = new RegisterSwitcher();

    @Test
    public void testSwap_emptyString_sameEmptyString() {
        assertEquals("", registerSwitcher.swap(""));
    }

    @Test
    public void testSwap_oneCapitalLetter_caseSwitched() {
        assertEquals("G", registerSwitcher.swap("g"));
    }

    @Test
    public void testSwap_oneSmallLetter_caseSwitched() {
        assertEquals("g", registerSwitcher.swap("G"));
    }

    @Test
    public void testSwap_severalLettersOfDifferentCase_caseSwitched() {
        assertEquals("gFklMn", registerSwitcher.swap("GfKLmN"));
    }

    @Test
    public void testSwap_severalLettersOfDifferentCaseAndOtherChars_caseSwitchedAndCharsRemained() {
        assertEquals("g_Fk8l&Mn", registerSwitcher.swap("G_fK8L&mN"));
    }
}
