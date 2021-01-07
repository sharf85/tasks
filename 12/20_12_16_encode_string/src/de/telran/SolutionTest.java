package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        assertEquals("hel2o", solution.solve("hello"));
    }

    @Test
    void test_Input_aa_Result_a2() {
        assertEquals("a2", solution.solve("aa"));
    }

    @Test
    void test_Input_ab_Result_ab() {
        assertEquals("ab", solution.solve("ab"));
    }

    @Test
    void test_Input_aaa_Result_a3() {
        assertEquals("a3", solution.solve("aaa"));
    }

    @Test
    void test_Input_abb_Result_ab2() {
        assertEquals("ab2", solution.solve("abb"));
    }

    @Test
    void test_Input_abc_Result_abc() {
        assertEquals("abc", solution.solve("abc"));
    }

    @Test
    void test_Input_abbbc_Result_ab3c() {
        assertEquals("ab3c", solution.solve("abbbc"));
    }

    @Test
    void test_Input_abbcca_Result_ab2c2a() {
        assertEquals("ab2c2a", solution.solve("abbcca"));
    }

    @Test
    void test_Input_aaabbcdddd_Result_a3b2cd4() {
        assertEquals("a3b2cd4", solution.solve("aaabbcdddd"));
    }
}
