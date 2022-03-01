package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapServiceTest {

    HeapService hp = new HeapService();

    @Test
    public void testHeapSort_1element() {
        int[] numbers = {5};

        hp.heapSort(numbers);
        assertEquals(5, numbers[0]);
    }

    @Test
    public void testHeapSort_2UnsortedElements() {
        int[] numbers = {5, 1};

        hp.heapSort(numbers);

        int[] expected = {1, 5};
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testHeapSort_2SortedElements() {
        int[] numbers = {1, 5};

        hp.heapSort(numbers);

        int[] expected = {1, 5};
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testHeapSort_10Elements() {
        int[] numbers = {36, 31, 20, 40, 23, 18, 15, 79, 27, 83};

        hp.heapSort(numbers);

        int[] expected = {15, 18, 20, 23, 27, 31, 36, 40, 79, 83};
        assertArrayEquals(expected, numbers);
    }


}
