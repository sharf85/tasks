package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class IMaxElementStackTest {
    IMaxElementStack<Integer> maxElementStack;//декларирую

    @Test
    void addJustOneElement() {
        maxElementStack.addLast(1);
        assertEquals(1, maxElementStack.getMax());
        assertEquals(1, maxElementStack.getLast());

    }

    @Test
    void maxElementOfTwo() {
        maxElementStack.addLast(1);
        maxElementStack.addLast(10);
        assertEquals(10, maxElementStack.getMax());
        assertEquals(10, maxElementStack.getLast());
    }

    @Test
    void maxElementOfThree() {
        maxElementStack.addLast(1);
        maxElementStack.addLast(10);
        maxElementStack.addLast(-10);
        assertEquals(10, maxElementStack.getMax());
        assertEquals(-10, maxElementStack.getLast());
    }

    @Test
    void maxElementOfFour() {
        maxElementStack.addLast(1);
        maxElementStack.addLast(10);
        maxElementStack.addLast(-10);
        maxElementStack.addLast(20);
        assertEquals(20, maxElementStack.getMax());
        assertEquals(20, maxElementStack.getLast());
    }

    @Test
    void removeElement() {
        maxElementStack.addLast(1);
        maxElementStack.addLast(10);
        maxElementStack.addLast(-10);
        maxElementStack.addLast(20);
        maxElementStack.removeLast();
        assertEquals(10, maxElementStack.getMax());
        assertEquals(-10, maxElementStack.getLast());
    }
}
