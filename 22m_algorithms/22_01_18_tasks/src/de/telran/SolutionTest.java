package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void testcontainsProduct() {
        int[] numbers = {2, 8, 12, 14, 25, 45, 50};

        assertTrue(solution.containsProduct(numbers, 100));
        assertTrue(solution.containsProduct(numbers, 200));
        assertTrue(solution.containsProduct(numbers, 90));
        assertTrue(solution.containsProduct(numbers, 168));

        assertTrue(solution.containsProduct(numbers, 600));
        assertTrue(solution.containsProduct(numbers, 1125));
        assertTrue(solution.containsProduct(numbers, 16));

        assertFalse(solution.containsProduct(numbers, 420));
        assertFalse(solution.containsProduct(numbers, 80));
        assertFalse(solution.containsProduct(numbers, 1000000));
    }

    @Test
    public void testcontainsProductEff() {
        int[] numbers = {2, 8, 12, 14, 25, 45, 50};

        assertTrue(solution.containsProductEff(numbers, 100));
        assertTrue(solution.containsProductEff(numbers, 200));
        assertTrue(solution.containsProductEff(numbers, 90));
        assertTrue(solution.containsProductEff(numbers, 168));

        assertTrue(solution.containsProductEff(numbers, 600));
        assertTrue(solution.containsProductEff(numbers, 1125));
        assertTrue(solution.containsProductEff(numbers, 16));

        assertFalse(solution.containsProductEff(numbers, 420));
        assertFalse(solution.containsProductEff(numbers, 80));
        assertFalse(solution.containsProductEff(numbers, 1000000));
    }

    @Test
    public void testSolutionEncode() {
        assertEquals("4a2b4cd", solution.encode("aaaabbccccd"));
        assertEquals("4ab4cd", solution.encode("aaaabccccd"));
        assertEquals("4a2b4c2d", solution.encode("aaaabbccccdd"));
        assertEquals("4a", solution.encode("aaaa"));
        assertEquals("10a", solution.encode("aaaaaaaaaa"));
        assertEquals("a", solution.encode("a"));
        assertEquals("", solution.encode(""));
    }

    @Test
    public void testSolutionDecode() {
        assertEquals("aaaabbccccd", solution.decode("4a2b4cd"));
        assertEquals("aaaabccccd", solution.decode("4ab4cd"));
        assertEquals("aaaabbccccdd", solution.decode("4a2b4c2d"));
        assertEquals("aaaa", solution.decode("4a"));
        assertEquals("aaaaaaaaaa", solution.decode("10a"));
        assertEquals("aaaaaaaaaaaaaaa", solution.decode("15a"));
        assertEquals("a", solution.decode("a"));
        assertEquals("", solution.decode(""));
    }

}
