package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntSquareTest {

    IntSquare square = new IntSquare();

    @Test
    public void testCompute_1_1() {
        assertEquals(1, square.compute(1));
    }

    @Test
    public void testCompute_2_4() {
        assertEquals(4, square.compute(2));
    }

    @Test
    public void testCompute_11_121() {
        assertEquals(121, square.compute(11));
    }
}
