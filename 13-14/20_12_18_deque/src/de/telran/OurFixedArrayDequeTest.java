package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurFixedArrayDequeTest {
    OurFixedArrayDeque<Integer> deque = new OurFixedArrayDeque<>(4);

    @Test
    void testSize_emptyList_zero() {
        assertEquals(0, deque.size());
    }

    @Test
    void testGetFirst_emptyList_throwsEmptyDequeException() {
        assertThrows(EmptyDequeException.class, () -> {
            deque.getFirst();
        });
    }

    @Test
    void testGetLast_emptyList_throwsEmptyDequeException() {
        assertThrows(EmptyDequeException.class, () -> {
            deque.getLast();
        });
    }

    @Test
    void testRemoveFirst_emptyList_throwsEmptyDequeException() {
        assertThrows(EmptyDequeException.class, () -> {
            deque.removeFirst();
        });
    }

    @Test
    void testRemoveLast_emptyList_throwsEmptyDequeException() {
        assertThrows(EmptyDequeException.class, () -> {
            deque.removeLast();
        });
    }

    @Test
    void testSizeAndAddLast_addSeveralElements_correctSize() {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(3, deque.size());
    }

    @Test
    void testSizeAndAddFirst_addSeveralElements_correctSize() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertEquals(3, deque.size());
    }

    @Test
    void testGetLastAndAddLast_addSeveralElements_correctOrderOfElements() {
        int[] numbers = new int[]{0, 1, 2};
        for (int i = 0; i < 3; i++) {
            deque.addLast(i);
            assertEquals(numbers[i], deque.getLast());
        }
    }

    @Test
    void testGetFirstAndAddFirst_addSeveralElements_correctOrderOfElements() {
        int[] numbers = new int[]{0, 1, 2};
        for (int i = 0; i < 3; i++) {
            deque.addFirst(i);
            assertEquals(numbers[i], deque.getFirst());
        }
    }

    @Test
    void testGetFirstAndAddFirst_GetLastAndAddLast_correctOrderOfElements() {
        //int[] numbers = new int[]{10, 100,  0};
        deque.addFirst(10);
        deque.addLast(100);
        deque.addLast(0);
        assertEquals(10, deque.getFirst());
        assertEquals(0, deque.getLast());
    }

    @Test
    void testAddFirst_throwsDequeOverflowException() {
        deque.addFirst(12);
        deque.addFirst(12);
        deque.addFirst(12);
        deque.addFirst(12);
        assertThrows(DequeOverflowException.class, () -> deque.addFirst(33));
    }

    @Test
    void testAddLast_throwsDequeOverflowException() {
        deque.addLast(10);
        deque.addLast(-55);
        deque.addLast(3);
        deque.addLast(1);
        assertEquals(4, deque.size());
        assertThrows(DequeOverflowException.class, () -> deque.addLast(33));
    }

    @Test
    public void testRemoveLastSeveralTimes_throwsEmptyDequeException() {
        deque.addLast(10);
        deque.removeLast();
        assertThrows(EmptyDequeException.class, () -> deque.removeLast());
    }

    @Test
    public void testRemoveFirstSeveralTimes_throwsEmptyDequeException() {
        deque.addFirst(101);
        deque.removeFirst();
        assertThrows(EmptyDequeException.class, () -> deque.removeFirst());
    }

    @Test
    public void testIterable() {
        OurFixedArrayDeque<Integer> deque = new OurFixedArrayDeque<Integer>(6);
        Integer[] expected = {15, 3, 4, 4};

        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.removeFirst();
        deque.removeFirst();
        deque.addFirst(15);
        deque.addLast(4);
        deque.addLast(4);

        int i = 0;
        for (Integer elt : deque) {
            System.out.println(elt);
            assertEquals(expected[i], elt);
            i++;
        }
        assertEquals(4, i);
    }
}
