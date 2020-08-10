package com.telran;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OurArrayDequeTest {

    OurArrayDeque<Integer> deque = new OurArrayDeque<>(16);

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

    @Test()
    public void testRemoveFirst_removeFromEmptyDeque_throwsOurDequeEmptyException() {
        assertThrows(OurDequeEmptyException.class, () -> deque.removeFirst());
    }

    @Test
    public void testRemoveLast_removeFromEmptyDeque_throwsOurDequeEmptyException() {
        assertThrows(OurDequeEmptyException.class, () -> deque.removeLast());
    }

    @Test()
    public void testAddFirst_zeroCapacityAndAddToFullDeque_throwsOurDequeOverflowException() {
        deque = new OurArrayDeque<>(0);
        assertThrows(OurDequeOverflowException.class, () -> deque.addFirst(5));
    }

    @Test
    public void testAddLast_zeroCapacityAndAddToFullDeque_throwsOurDequeOverflowException() {
        deque = new OurArrayDeque<>(0);
        assertThrows(OurDequeOverflowException.class, () -> deque.addLast(7));
    }

    @Test()
    public void testAddFirst_2CapacityAndAddToFullDeque_throwsOurDequeOverflowException() {
        deque = new OurArrayDeque<>(2);
        deque.addLast(3);
        deque.addFirst(8);

        assertThrows(OurDequeOverflowException.class, () -> deque.addFirst(5));
    }

    @Test
    public void testAddLast_2CapacityAndAddToFullDeque_throwsOurDequeOverflowException() {
        deque = new OurArrayDeque<>(2);
        deque.addLast(3);
        deque.addFirst(8);

        assertThrows(OurDequeOverflowException.class, () -> deque.addLast(7));
    }

    @Test
    void testDefaultIterator() {
        deque = new OurArrayDeque<>(2);
        deque.addLast(3);
        deque.addFirst(8);
        Iterator<Integer> it = deque.iterator();
        List<Integer> res = new ArrayList<>();
        while (it.hasNext()) {
            int current = it.next();
            res.add(current);
        }
        List<Integer> expected = Arrays.asList(8, 3);
        assertEquals(expected, res);
    }

    @Test
    void testIterable() {
        deque = new OurArrayDeque<>(2);
        deque.addLast(3);
        deque.addFirst(8);

        List<Integer> res = new ArrayList<>();

        for (int num : deque) {
            res.add(num);
        }

        List<Integer> expected = Arrays.asList(8, 3);
        assertEquals(expected, res);
    }

}
