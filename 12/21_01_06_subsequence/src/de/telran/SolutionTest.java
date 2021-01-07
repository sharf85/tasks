package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    String text = "hello";

    @Test
    public void testIsPattern_helloAndHello_true() {
        String pattern = "hello";
        assertTrue(solution.solve(text, pattern));
    }

    @Test
    public void testIsPattern_helloAndH_true() {
        String pattern = "h";
        assertTrue(solution.solve(text, pattern));
    }

    @Test
    public void testIsPattern_helloAndO_true() {
        String pattern = "o";
        assertTrue(solution.solve(text, pattern));
    }

    @Test
    public void testIsPattern_helloAndHo_true() {
        String pattern = "ho";
        assertTrue(solution.solve(text, pattern));
    }

    @Test
    public void testIsPattern_helloAndOh_false() {
        String pattern = "oh";
        assertFalse(solution.solve(text, pattern));
    }

    @Test
    public void testIsPattern_helloAndHll_true() {
        String pattern = "hll";
        assertTrue(solution.solve(text, pattern));
    }

    @Test
    public void testIsPattern_helloAndLlh_false() {
        String pattern = "llh";
        assertFalse(solution.solve(text, pattern));
    }
}
