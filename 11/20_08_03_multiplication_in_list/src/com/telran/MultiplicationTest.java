package com.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {

    Multiplication multiplication = new Multiplication();
    List<Integer> numbers = Arrays.asList(1, 4, 5, 8, 10, 11, 11, 20, 25);

    @Test
    public void testIsMultiplied_1_false() {
        assertFalse(multiplication.isMultiplied(numbers, 1));
    }

    @Test
    public void testIsMultiplied_16_false() {
        assertFalse(multiplication.isMultiplied(numbers, 16));
    }

    @Test
    public void testIsMultiplied_40_true() {
        assertTrue(multiplication.isMultiplied(numbers, 40));
    }

    @Test
    public void testIsMultiplied_64_false() {
        assertFalse(multiplication.isMultiplied(numbers, 64));
    }

    @Test
    public void testIsMultiplied_121_true() {
        assertTrue(multiplication.isMultiplied(numbers, 121));
    }

    @Test
    public void testIsMultiplied_500_true() {
        assertTrue(multiplication.isMultiplied(numbers, 500));
    }

    @Test
    public void testIsMultiplied_8_true() {
        assertTrue(multiplication.isMultiplied(numbers, 8));
    }

    @Test
    public void testIsMultiplied_1000_false() {
        assertFalse(multiplication.isMultiplied(numbers, 1000));
    }
}
