package de.telran;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackMaxTest {

    StackMax<Integer> myStack = new StackMax<>(new IntegerBasicComparator());

    @Test
    public void testRemoveLast_empty_Stack_throwsIOOBE() {
        assertThrows(NoSuchElementException.class, () -> myStack.getLast());
    }

    @Test
    public void testAddLast() {
        myStack.addLast(0);
        assertEquals(0, myStack.getLast());

        myStack.addLast(-1);
        assertEquals(-1, myStack.getLast());

        myStack.addLast(10);
        assertEquals(10, myStack.getLast());
    }

    @Test
    public void testGetLast_not_empty_Stack() {
        myStack.addLast(0);
        assertEquals(0, myStack.getLast());

        myStack.addLast(-1);
        assertEquals(-1, myStack.getLast());

        myStack.addLast(1);
        assertEquals(1, myStack.getLast());
    }

    @Test
    public void testSize_empty_Stack() {
        assertEquals(0, myStack.size());
    }

    @Test
    public void testSize_not_empty_Stack() {
        myStack.addLast(1);
        assertEquals(1, myStack.size());

        myStack.addLast(1);
        assertEquals(2, myStack.size());

        myStack.addLast(1);
        assertEquals(3, myStack.size());
    }


    @Test
    public void testGetMax() {
        myStack.addLast(1);
        assertEquals(1, myStack.getMax());

        myStack.addLast(100);
        assertEquals(100, myStack.getMax());

        myStack.addLast(-5);
        assertEquals(100, myStack.getMax());

        myStack.addLast(0);
        assertEquals(100, myStack.getMax());

        myStack.addLast(0);
        assertEquals(100, myStack.getMax());

        myStack.addLast(20000);
        assertEquals(20000, myStack.getMax());
    }

    @Test
    public void testGetMax_dynamic() {
        myStack.addLast(1);
        myStack.addLast(1000);
        myStack.addLast(-10);
        myStack.addLast(900);
        myStack.addLast(10);
        myStack.addLast(500);
        myStack.addLast(0);
        myStack.addLast(300);
        myStack.addLast(10000);
        myStack.addLast(100);
        myStack.addLast(55);

        assertEquals(10000, myStack.getMax());

        myStack.removeLast();
        myStack.removeLast();
        myStack.removeLast();
        myStack.removeLast();

        assertEquals(1000, myStack.getMax());
    }

    @Test
    public void testRemoveLast_returned_values() {
        myStack.addLast(5);
        myStack.addLast(1000);
        myStack.addLast(-10);
        myStack.addLast(10000);
        myStack.addLast(-100);

        assertEquals(-100, myStack.removeLast());
        assertEquals(10000, myStack.removeLast());
        assertEquals(-10, myStack.removeLast());
        assertEquals(1000, myStack.removeLast());
        assertEquals(5, myStack.removeLast());
    }

    @Test
    public void testSize_empty() {
        assertEquals(0, myStack.size());
    }

    @Test
    public void testSize_not_empty() {
        myStack.addLast(1);
        assertEquals(1, myStack.size());

        myStack.addLast(1);
        assertEquals(2, myStack.size());

        myStack.addLast(1);
        assertEquals(3, myStack.size());

        myStack.removeLast();
        assertEquals(2, myStack.size());

        myStack.removeLast();
        assertEquals(1, myStack.size());

        myStack.removeLast();
        assertEquals(0, myStack.size());

        assertThrows(NoSuchElementException.class, () -> myStack.removeLast());
        assertThrows(NoSuchElementException.class, () -> myStack.removeLast());
    }
}
