package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceServiceTest {
    SequenceService seq = new SequenceService();

    @Test
    void testIsSubsequence_true() {
        String sequence = "hello";
        String pattern = "ll";

        assertTrue(seq.isSubsequence(sequence, pattern));
    }

    @Test
    void testIsSubsequence_false() {
        String sequence = "hello";
        String pattern = "ohl";

        assertFalse(seq.isSubsequence(sequence, pattern));
    }

    @Test
    public void testIsSubsequence_isSubsequence() {
        assertTrue(seq.isSubsequence("hello", "hlo"));
    }

    @Test
    public void testIsSubsequence_isSubsequence_emptyPattern_true() {
        assertTrue(seq.isSubsequence("hello", ""));
    }

    @Test
    public void testIsSubsequence_isSubsequence_emptyPatternAndEmptyText_true() {
        assertTrue(seq.isSubsequence("", ""));
    }

    @Test
    public void testIsSubsequence_isSubsequence_textShorterThanPattern_false() {
        assertFalse(seq.isSubsequence("hello", "helloo"));
    }

    @Test
    public void testIsSubsequence_isSubsequence_false() {
        assertFalse(seq.isSubsequence("hello", "hoo"));
    }

    @Test
    public void testIsSubsequence_emptyPattern_true() {
        assertTrue(seq.isSubsequence("Subsequence Finder", ""));
    }

    @Test
    public void testIsSubsequence_3lettersOnAfterAnother_true() {
        assertTrue(seq.isSubsequence("Subsequence Finder", "ser"));
    }

    @Test
    public void testIsSubsequence_3letters_false() {
        assertFalse(seq.isSubsequence("Subsequence Finder", "olo"));
    }

    @Test
    public void testIsSubsequence_1() {
        assertTrue(seq.isSubsequence("hello", "hlo"));
    }

    @Test
    public void testIsSubsequence_2() {
        assertTrue(seq.isSubsequence("dfkffgghh", "fgh"));
    }

    @Test
    public void testIsSubsequence_3() {
        assertFalse(seq.isSubsequence("dfkffhhg", "fgh"));
    }

    @Test
    public void testIsSubsequence_4() {
        assertTrue(seq.isSubsequence("hello world", "hol"));
    }

    @Test
    public void testIsSubsequence_5() {
        assertTrue(seq.isSubsequence("ggaaaccbjjc", "abc"));
    }

    @Test
    public void testIsSubsequence_6() {
        assertTrue(seq.isSubsequence("hello", "hello"));
    }

    @Test
    public void testIsSubsequence_7() {
        assertFalse(seq.isSubsequence("", "hello"));
    }


    public String text = "Subsequence Finder";

    @Test
    public void test_lengthOfLongestCommonSubsequence_0() {
        assertEquals(0, seq.getLengthMaxSharedSequence(text, "mm"));
        assertEquals(0, seq.getLengthMaxSharedSequence("mm", text));
    }

    @Test
    public void test_lengthOfLongestCommonSubsequence_3() {
        assertEquals(3, seq.getLengthMaxSharedSequence(text, "ser"));
    }

    @Test
    public void testIsSubsequence_3lettersOnAfterAnother_3() {
        assertEquals(3, seq.getLengthMaxSharedSequence(text, "ser"));
    }

    @Test
    public void testIsSubsequence_3lettersOnAfterAnother_4() {
        assertEquals(4, seq.getLengthMaxSharedSequence(text, "uebfircmm"));
    }
}
