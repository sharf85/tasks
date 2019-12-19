package com.telran;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    private Fibonacci fibonacci = new Fibonacci();

    @Test
    public void testReminder() {
        assertEquals(3, fibonacci.reminder(44, 5));
        assertEquals(8, fibonacci.reminder(1036, 11));
    }
}