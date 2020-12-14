package de.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OurArrayListTest extends OurListTest {

    @BeforeEach
    public void init() {
        list = new OurArrayList<>();
        stringList = new OurArrayList<>();
    }

    @Test
    public void testRemoveById_addCapacityNumberElementsAndRemoveLast_correct() {

        for (int i = 0; i < 16; i++) {
            list.addLast(i);
        }

        assertEquals(15, list.removeById(15));
        assertEquals(15, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(15));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(15, 111));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(15));

    }

    @Test
    public void testRemoveById_addCapacityNumberElementsAndRemoveFirst_correct() {

        for (int i = 0; i < 16; i++) {
            list.addLast(i);
        }

        assertEquals(0, list.removeById(0));
        assertEquals(15, list.size());

        for (int i = 0; i < list.size(); i++) {
            assertEquals(1 + i, list.get(i));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(15));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(15, 111));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(15));
    }

    @Test
    public void testRemoveById_addCapacityNumberElementsAndRemoveIntermediate_correct() {

        for (int i = 0; i < 18; i++) {
            list.addLast(i);
        }

        assertEquals(5, list.removeById(5));
//        {0,1,2,3,4,  6,7,8,9,10,11,12,13,14,15,16,17}

        assertEquals(17, list.size());

        for (int i = 0; i < 5; i++) {
            assertEquals(i, list.get(i));
        }

        for (int i = 5; i < list.size(); i++) {
            assertEquals(i + 1, list.get(i));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(17));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(17, 111));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(17));
    }

    @Test
    public void testAddLast_addInitialCapacityPlusOneElements_correctSizAndCapacity() {
        for (int i = 0; i < 17; i++) {
            list.addLast(i);
        }

        assertEquals(17, list.size());
    }

}
