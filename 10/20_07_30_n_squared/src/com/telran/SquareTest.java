package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    Square square = new Square();

    @Test
    public void testSqr_1_1() {
        assertEquals(1, square.sqr(1));
    }

    @Test
    public void testSqr_2_4() {
        assertEquals(4, square.sqr(2));
    }

    @Test
    public void testSqr_11_121() {
        assertEquals(121, square.sqr(11));
    }
}
