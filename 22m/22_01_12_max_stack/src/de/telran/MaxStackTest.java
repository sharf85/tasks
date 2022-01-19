package de.telran;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

abstract class MaxStackTest {
    MaxStack maxStack;

    @Test
    public void testGetMax_empty() {
        assertThrows(NoSuchElementException.class, () ->{
            maxStack.getMax();
        });
    }

    @Test
    public void testGet_empty() {
        assertThrows(NoSuchElementException.class, () ->{
            maxStack.get();
        });
    }

    @Test
    public void TestRemove__empty() {
        assertThrows(NoSuchElementException.class, () ->{
            maxStack.get();
        });
    }

    @Test
    public void testAddGet_empty() {
        maxStack.add(5);
        assertEquals(5, maxStack.get());
    }

    @Test
    public void testAddGet_twoElements() {
        maxStack.add(5);
        maxStack.add(10);
        assertEquals(10, maxStack.get());
    }

    @Test
    public void testRemoveSize_oneElement() {
        maxStack.add(5);
        assertEquals(5, maxStack.remove());
        assertEquals(0, maxStack.size());
    }

    @Test
    public void testRemoveSize_twoElements() {
        maxStack.add(5);
        maxStack.add(10);
        assertEquals(10, maxStack.remove());
        assertEquals(1, maxStack.size());
    }

    @Test
    public void testGetMax_1Element() {
        maxStack.add(2);
        assertEquals(2, maxStack.getMax());
    }

    @Test
    public void testGetMax_2Elements() {
        maxStack.add(2);
        maxStack.add(5);
        assertEquals(5, maxStack.getMax());
    }

    @Test
    public void testGetMaxSize_severalElements() {
        maxStack.add(2);
        maxStack.add(5);
        maxStack.add(10);
        maxStack.add(5);
        maxStack.add(25);
        maxStack.remove();
        maxStack.add(6);
        maxStack.add(10);
        assertEquals(10, maxStack.getMax());
        assertEquals(6, maxStack.size());
    }
}
