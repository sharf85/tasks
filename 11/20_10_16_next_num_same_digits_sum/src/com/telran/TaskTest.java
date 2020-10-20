package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    Task task = new Task();

    @Test
    public void test1() {
        assertEquals(10, task.solve(1));
    }

    @Test
    public void test2() {
        assertEquals(11, task.solve(2));
    }

    @Test
    public void test3() {
        assertEquals(14, task.solve(5));
    }

    @Test
    public void test4() {
        assertEquals(189, task.solve(99));
    }

    @Test
    public void test5() {
        assertEquals(1_000_000, task.solve(100_000));
    }

    @Test
    public void test6() {
        assertEquals(162, task.solve(153));
    }

    @Test
    public void test7() {
        assertEquals(269, task.solve(197));
    }
}
