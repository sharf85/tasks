package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubsequenceFinderTest {

    SubsequenceFinder finder = new SubsequenceFinder();

    @Test
    public void testIsSubsequence_emptyPatternAndEmptyText_true() {
        assertTrue(finder.isSubsequence("", ""));
    }

    @Test
    public void testIsSubsequence_emptyPatternAndAnyText_true() {
        assertTrue(finder.isSubsequence("", " 9"));
    }

    @Test
    public void testIsSubsequence_oneLetterPatternAndAnyText_false() {
        assertFalse(finder.isSubsequence("a", " 9"));
    }

    @Test
    public void testIsSubsequence_oneLetterPatternAndAnyText_true() {
        assertTrue(finder.isSubsequence("a", " a9"));
    }

    @Test
    public void testIsSubsequence_mixedPatternAndMixedText_false() {
        assertFalse(finder.isSubsequence("abcs", " sdfavdfvb;lkcooo"));
    }

    @Test
    public void testIsSubsequence_mixedPatternAndMixedText_true() {
        assertTrue(finder.isSubsequence("abcs", " sdfavdfvb;lkcooso"));
    }

    @Test
    public void testIsSubsequence_StringSubstring_true() {
        String first = "bcd";
        String second = "A$%bGDFcLKKd";
        assertTrue(finder.isSubsequence(first, second));
    }

    @Test
    public void testIsSubsequence_StringSubstring_false() {
        String first = "bcd";
        String second = "A$%bGDFcLKK";
        assertFalse(finder.isSubsequence(first, second));
    }

    @Test
    public void testIsSubsequence_StringEmptySubstring_true() {
        String first = "";
        String second = "A$%bGDFcLKK";
        assertTrue(finder.isSubsequence(first, second));
    }

    @Test
    public void testIsSubsequence_StringSubstringEmpty_false() {
        String first = "bcd";
        String second = "";
        assertFalse(finder.isSubsequence(first, second));
    }

    @Test
    public void testIsSubsequence_StringAndSameSubstring_true() {
        String first = "bcd";
        String second = "bcd";
        assertTrue(finder.isSubsequence(first, second));
    }

    @Test
    public void testIsSubsequence_StringDoubleSymbolSubstring_false() {
        String first = "bccd";
        String second = "A$%bGDFcLKKd";
        assertFalse(finder.isSubsequence(first, second));
    }

    @Test
    public void testIsSubsequence_StringSubstringDoubleSymbol_true() {
        String first = "bcd";
        String second = "A$%bGDFcLcKKd";
        assertTrue(finder.isSubsequence(first, second));
    }

    @Test
    public void testIsSubsequence_StringDoubleSymbolSubstringDoubleSymbol_true() {
        String first = "bccd";
        String second = "A$%bGDFcLcKKd";
        assertTrue(finder.isSubsequence(first, second));
    }

    @Test
    public void testIsSubsequence_StringDoubleSymbolSubstringDoubleSymbolBeside_true() {
        String first = "bccd";
        String second = "A$%bGDFccLKKd";
        assertTrue(finder.isSubsequence(first, second));
    }
}
