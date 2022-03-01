package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution sol = new Solution();

    @Test
    public void test1() {
        char[] brackets = {'{', '}', '(', '[', ']', ')'};
        assertTrue(sol.areBracketsCorrect(brackets));
    }

    @Test
    public void test2() {
        char[] brackets = {'{', '}', '(', '[', ']', '{', '(', ')', '}', ')'};
        assertTrue(sol.areBracketsCorrect(brackets));
    }

    @Test
    public void test3() {
        char[] brackets = {'{', '(', ']'};
        assertFalse(sol.areBracketsCorrect(brackets));
    }

    @Test
    public void test4() {
        char[] brackets = {'{', '}', '(', '[', ']', ')', '}'};
        assertFalse(sol.areBracketsCorrect(brackets));
    }

    @Test
    public void test5() {
        char[] brackets = {'{', '}', '(', '[', ']', ')', '('};
        assertFalse(sol.areBracketsCorrect(brackets));
    }

    @Test
    public void test6() {
        char[] brackets = {'{', '(', '}', ')'};
        assertFalse(sol.areBracketsCorrect(brackets));
    }

    @Test
    public void test7() {
        char[] brackets = {'{', '}', '}', ')'};
        assertFalse(sol.areBracketsCorrect(brackets));
    }

    @Test
    public void test8() {
        char[] brackets = {'}', '}'};
        assertFalse(sol.areBracketsCorrect(brackets));
    }

    @Test
    public void test_countOrdersNumber1() {
        long[] array = {1000000, 1200000, 1250000, 1300000, 1600000, 1700000, 1800000, 1850000, 1890000};
        assertArrayEquals(new int[]{0, 1, 2, 3, 1, 1, 2, 3, 4}, sol.countOrdersNumber(array, 5));
    }
}
