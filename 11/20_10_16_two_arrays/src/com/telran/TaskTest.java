package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    Task task = new Task();

    @Test
    void testDoThings_oneMatch_1() {
        int[] A = {5, 0, 2, 3};
        int[] B = {3, 2, 1, 4};
        assertEquals(1, task.solve(A, B));
    }

    @Test
    void testDoThings_equalArrays_twoMatch_2() {
        int[] A = {5, 0, 2, 3};
        int[] B = {5, 0, 2, 3};
        assertEquals(2, task.solve(A, B));
    }

    @Test
    void testDoThings_equalArraysEqualDigits_oneMatch_1() {
        int[] A = {5, 5, 5, 5};
        int[] B = {5, 5, 5, 5};
        assertEquals(1, task.solve(A, B));
    }

    @Test
    void testDoThings_mixedArrays_oneMatch_1() {
        int[] A = {3, 1, 4, 0};
        int[] B = {2, 2, -1, 5};
        assertEquals(1, task.solve(A, B));
    }

    @Test
    void testDoThings_noMatch_0() {
        int[] A = {5, 7, 5, 4};
        int[] B = {3, 2, 1, 4};
        assertEquals(0, task.solve(A, B));
    }

    @Test
    void testDoThings8() {
        int[] A = {5, -7, -5, 4, 3};
        int[] B = {3, 2, 1, -10, 4};
        assertEquals(0, task.solve(A, B));
    }

    @Test
    void testDoThings_zeros() {
        int[] A = {0, 0, 0, 0, 0};
        int[] B = {0, 0, 0, 0, 0};
        assertEquals(4, task.solve(A, B));
    }
}
