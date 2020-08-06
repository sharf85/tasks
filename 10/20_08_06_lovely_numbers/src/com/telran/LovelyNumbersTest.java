package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LovelyNumbersTest {

    LovelyNumbers lovely = new LovelyNumbers();

    @Test
    public void testIsLovely_zero_true() {
        assertTrue(lovely.isLovely(3));
    }

    @Test
    public void testIsLovely_one_true() {
        assertTrue(lovely.isLovely(5));
    }

    @Test
    public void testIsLovely_two_true() {
        assertTrue(lovely.isLovely(55));
    }

    @Test
    public void testIsLovely_threeDifferent_true() {
        assertTrue(lovely.isLovely(123));
    }

    @Test
    public void testIsLovely_moreDifferent_true() {
        assertTrue(lovely.isLovely(1234567890));
    }

    @Test
    public void testIsLovely_threeSame_false() {
        assertFalse(lovely.isLovely(111));
    }

    @Test
    public void testIsLovely_moreSame_false() {
        assertFalse(lovely.isLovely(1115555444));
    }

}
