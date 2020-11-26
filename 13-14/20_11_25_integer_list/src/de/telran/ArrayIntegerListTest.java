package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntegerListTest {

    ArrayIntegerList list = new ArrayIntegerList();

    @Test
    public void testGet_() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
    }
}
