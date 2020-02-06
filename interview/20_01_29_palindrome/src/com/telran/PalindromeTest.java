package com.telran;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {
    Palindrome palindrome = new Palindrome();

    @Test
    public void testPalindromeFounder_oddNumbersOfLettersLowCase_True() {
        String str = "hellolleh";

        boolean res = palindrome.isPalindrome(str);
        assertTrue(res);
    }

    @Test
    public void testPalindromeFounder_oddNumbersOfLettersUpperCase_True() {
        String str = "HELLOLLEH";

        boolean res = palindrome.isPalindrome(str);
        assertTrue(res);
    }

    @Test
    public void testPalindromeFounder_oddNumbersOfLettersUpperLowCase_True() {
        String str = "HeLlollEh";

        boolean res = palindrome.isPalindrome(str);
        assertTrue(res);
    }

    @Test
    public void testPalindromeFounder_evenNumbersOfLettersUpperLowCase_True() {
        String str = "HeLloollEh";

        boolean res = palindrome.isPalindrome(str);
        assertTrue(res);
    }

    @Test
    public void testPalindromeFounder_oddNumbersOfLettersUpperLowCase_False() {
        String str = "HeLlollah";

        boolean res = palindrome.isPalindrome(str);
        assertFalse(res);
    }
}