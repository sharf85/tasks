package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntegerListTest {

    ArrayIntegerList list = new ArrayIntegerList();

    @Test
    public void testSize_emptyList_zero() {
        assertEquals(0, list.size());
    }

    @Test
    public void testGet_emptyList_throwsIOOBE() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-10));
    }

    @Test
    public void testRemoveById_emptyList_throwsIOOBE() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(-10));
    }

    @Test
    public void testSet_emptyList_throwsIOOBE() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(10, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-10, 0));
    }

    @Test
    public void testSizeAndAddLast_addSeveralElements_correctSize() {
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        assertEquals(3, list.size());
    }

    @Test
    public void testGetAndAddLast_addSeveralElements_correctOrderOfElements() {
        int[] numbers = {-5, 18, 3, 1, 10, 2, 0, 6};
        for (int number : numbers) {
            list.addLast(number);
        }

        for (int i = 0; i < numbers.length; i++) {
            assertEquals(numbers[i], list.get(i));
        }
    }

    @Test
    public void testRemoveById_addSeveralElementsAndRemoveLast_correct() {
        int[] numbers = {-5, 18, 3, 1, 10, 2, 0, 6};
        for (int number : numbers) {
            list.addLast(number);
        }

        assertEquals(6, list.removeById(7));
        assertEquals(7, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(7));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(7, 111));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(7));
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

    // TODO test remove zero-indexed element, remove a middle element, test 'set' in different places, 'clear'.
    // TODO test the behavior of the list while adding-removing-adding etc operation.

    @Test
    public void testAddLast_addInitialCapacityPlusOneElements_correctSizAndCapacity() {
        for (int i = 0; i < 17; i++) {
            list.addLast(i);
        }

        assertEquals(17, list.size());
        assertEquals(32, list.source.length);
    }

}
