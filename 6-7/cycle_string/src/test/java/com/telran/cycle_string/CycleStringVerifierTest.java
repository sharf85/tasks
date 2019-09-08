package com.telran.cycle_string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CycleStringVerifierTest {

    private CycleStringVerifier verifier;

    @Before
    public void init() {
        verifier = new CycleStringVerifier();
    }

    @Test
    public void testIsCycle_EmptyStrings_True() {
        String s1 = "";
        String s2 = "";

        assertTrue(verifier.isCycle(s1, s2));
    }

    @Test
    public void testIsCycle_StringsOfDifferentLength_False() {
        String s1 = "aaa";
        String s2 = "b";

        assertFalse(verifier.isCycle(s1, s2));
    }

    @Test
    public void testIsCycle_SimpleStringsEqual_True() {
        String s1 = "aaab";
        String s2 = "abaa";

        assertTrue(verifier.isCycle(s1, s2));
    }

    @Test
    public void testIsCycle_SimpleStringsNonEqual_False() {
        String s1 = "aaaa";
        String s2 = "aaba";

        assertFalse(verifier.isCycle(s1, s2));
    }
}
