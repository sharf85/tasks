package com.telran;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubsequenceTest {

    Subsequence subsequence = new Subsequence();

    @Test
    public void testSubsequence_True() {

        String text = "abcdeaab";
        String pattern = "acdaa";

        assertTrue(subsequence.isSubsequence(pattern, text));
    }

    @Test
    public void testSubsequence_False() {

        String text = "abcdeaab";
        String pattern = "acdca";

        assertFalse(subsequence.isSubsequence(pattern, text));
    }

    @Test
    public void testIsSubsequenceRecursive_Equals_true() {
        String text = "Hello";
        String pattern = "Hll";
        assertTrue(subsequence.isSubsequence(pattern, text));
    }

    @Test
    public void testIsSubsequenceRecursive_NonEquals_false() {
        String text = "Hello";
        String pattern = "Hllm";
        assertFalse(subsequence.isSubsequence(pattern, text));
    }

}