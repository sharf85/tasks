package de.telran.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {

    CustomList list = new CustomArrayList();

    @Test
    public void testSet_emptyList_throwsCustomOutOfBoundsException() {
        assertThrows(CustomOutOfBoundsException.class, () -> {
            list.set(0, 10);
        });
    }
}
