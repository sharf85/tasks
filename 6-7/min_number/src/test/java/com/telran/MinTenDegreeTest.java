package com.telran;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinTenDegreeTest {

    MinTenDegree minTenDegree;

    @Before
    public void init() {
        minTenDegree = new MinTenDegree();
    }

    @Test
    public void testGetTenDegree_inputOne_output0() {
        assertEquals(0, minTenDegree.getTenDegree(1));
    }

    @Test
    public void testGetTenDegree_input9_output0() {
        assertEquals(0, minTenDegree.getTenDegree(9));
    }

    @Test
    public void testGetTenDegree_inputLastNumber_outputLastNumber() {
        assertEquals(1_000_000_000, minTenDegree.getTenDegree(1_000_000_000));
    }

    @Test
    public void testGetTenDegree_input53799_output10000() {
        assertEquals(10000, minTenDegree.getTenDegree(53799));
    }

    @Test
    public void testGetTenDegree_input100000_output100000() {
        assertEquals(100000, minTenDegree.getTenDegree(100000));
    }
}
