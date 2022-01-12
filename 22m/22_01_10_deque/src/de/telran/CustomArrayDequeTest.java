package de.telran;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayDequeTest {

    CustomArrayDeque<Integer> deque = new CustomArrayDeque<>();

    @Test
    public void testSize_newInstance_0() {
        assertEquals(0, deque.size());
    }

    @Test
    public void testSize_addLast3elements_3() {
        deque.addLast(5);
        deque.addLast(2);
        deque.addLast(7);

        assertEquals(3, deque.size());
    }

    @Test
    public void testSize_addFirst2elements_2() {
        deque.addFirst(5);
        deque.addFirst(2);

        assertEquals(2, deque.size());
    }

    @Test
    public void testSize_addFirst2elementsAndAddLast1_3() {
        deque.addFirst(5);
        deque.addFirst(2);
        deque.addLast(1);

        assertEquals(3, deque.size());
    }

    @Test
    public void testAddLast_adds1elt_getLast() {
        deque.addLast(5);
        assertEquals(5, deque.getLast());
    }

    @Test
    public void testAddLast_adds2elt_getLast() {
        deque.addLast(5);
        deque.addLast(7);
        assertEquals(7, deque.getLast());
    }

    @Test
    public void testAddLast_adds3elt_getLast() {
        deque.addLast(5);
        deque.addLast(7);
        deque.addLast(-1);
        assertEquals(-1, deque.getLast());
    }

    @Test
    public void testAddFirst_adds1elt_getFirst() {
        deque.addFirst(5);
        assertEquals(5, deque.getFirst());
    }

    @Test
    public void testAddFirst_adds2elt_getFirst() {
        deque.addFirst(5);
        deque.addFirst(7);
        assertEquals(7, deque.getFirst());
    }

    @Test
    public void testAddFirst_adds3elt_getFirst() {
        deque.addFirst(5);
        deque.addFirst(7);
        deque.addFirst(-1);
        assertEquals(-1, deque.getFirst());
    }

    @Test
    public void testAddLast_adds1elt_getFirstGetLast() {
        deque.addLast(3);
        assertEquals(3, deque.getFirst());
        assertEquals(3, deque.getLast());
    }

    @Test
    public void testAddFirst_adds2elt_getFirstGetLast() {
        deque.addFirst(3);
        deque.addFirst(8);
        assertEquals(8, deque.getFirst());
        assertEquals(3, deque.getLast());
    }

    @Test
    public void testAddFirstAndAddLast_adds5elt_getFirstGetLast() {
        deque.addFirst(3);
        deque.addFirst(8);
        deque.addFirst(4);
        deque.addLast(0);
        deque.addLast(-9);
        assertEquals(4, deque.getFirst());
        assertEquals(-9, deque.getLast());

        assertEquals(5, deque.size());
    }

    @Test
    public void testRemoveLast_addFirst1eltAndRemoves1_size0() {
        deque.addFirst(3);
        assertEquals(3, deque.removeLast());

        assertEquals(0, deque.size());
    }

    @Test
    public void testRemoveLast_addLast1eltAndRemoves1_size0() {
        deque.addLast(3);
        assertEquals(3, deque.removeLast());

        assertEquals(0, deque.size());
    }

    @Test
    public void testRemoveFirst_addFirst1eltAndRemoves1_size0() {
        deque.addFirst(3);
        assertEquals(3, deque.removeFirst());

        assertEquals(0, deque.size());
    }

    @Test
    public void testRemoveFirst_addLast1eltAndRemoves1_size0() {
        deque.addLast(3);
        assertEquals(3, deque.removeFirst());

        assertEquals(0, deque.size());
    }

    @Test
    public void testAddRemoveMix_severalElementsAdded_removeSeveralElements() {
        deque.addLast(3);
        deque.addFirst(8);
        assertEquals(3, deque.removeLast());
        deque.addFirst(-5);
        deque.addFirst(-2);
        deque.addFirst(7);
        deque.addLast(10);
        assertEquals(7, deque.removeFirst());
        deque.addLast(13);
        assertEquals(5, deque.size());
    }

    @Test
    void testSize_emptyList_zero() {
        assertEquals(0, deque.size());
    }

    @Test
    void testGetFirst_emptyList_throwsEmptyDequeException() {
        assertThrows(NoSuchElementException.class, () -> {
            deque.getFirst();
        });
    }

    @Test
    void testGetLast_emptyList_throwsEmptyDequeException() {
        assertThrows(NoSuchElementException.class, () -> {
            deque.getLast();
        });
    }

    @Test
    void testRemoveFirst_emptyList_throwsEmptyDequeException() {
        assertThrows(NoSuchElementException.class, () -> {
            deque.removeFirst();
        });
    }

    @Test
    void testRemoveLast_emptyList_throwsEmptyDequeException() {
        assertThrows(NoSuchElementException.class, () -> {
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


//    @Test
//    public void testIterable() {
//        OurFixedArrayDeque<Integer> deque = new OurFixedArrayDeque<Integer>(6);
//        Integer[] expected = {15, 3, 4, 4};
//
//        deque.addLast(1);
//        deque.addLast(2);
//        deque.addLast(3);
//        deque.removeFirst();
//        deque.removeFirst();
//        deque.addFirst(15);
//        deque.addLast(4);
//        deque.addLast(4);
//
//        int i = 0;
//        for (Integer elt : deque) {
//            System.out.println(elt);
//            assertEquals(expected[i], elt);
//            i++;
//        }
//        assertEquals(4, i);
//    }
}
