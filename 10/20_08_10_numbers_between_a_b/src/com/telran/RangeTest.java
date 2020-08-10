package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {
    Range range = new Range();

    @Test
    public void testGetQtyInInterval_1and2_1() {
        assertEquals(1, range.getQtyInInterval(1, 2));
    }

    @Test
    public void testGetQtyInInterval_1and3_1() {
        assertEquals(1, range.getQtyInInterval(1, 3));
    }

    @Test
    public void testGetQtyInInterval_1and6_2() {
        assertEquals(2, range.getQtyInInterval(1, 6));
    }

    @Test
    public void testGetQtyInInterval_2and6_2() {
        assertEquals(2, range.getQtyInInterval(2, 6));
    }

    @Test
    public void testGetQtyInInterval_3and6_1() {
        assertEquals(1, range.getQtyInInterval(3, 6));
    }

    @Test
    public void testGetQtyInInterval_3and8_1() {
        assertEquals(1, range.getQtyInInterval(3, 8));
    }

    @Test
    public void testGetQtyInInterval_25and100_5() {
        assertEquals(5, range.getQtyInInterval(25, 100));
    }
}
