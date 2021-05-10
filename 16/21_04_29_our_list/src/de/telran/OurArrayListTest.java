package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OurArrayListTest {

    OurArrayList<Integer> integerList = new OurArrayList<>();

    @Test
    public void testSize_newList() {
        assertEquals(0, integerList.size());
    }

    @Test
    public void testAddAndGet_severalElements() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);

        assertEquals(3, integerList.size());

        assertEquals(-7, integerList.get(0));
        assertEquals(-17, integerList.get(1));
        assertEquals(5, integerList.get(2));
    }

    @Test
    public void testAddAndGet_severalElements_throwsIOOBE() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.get(-3);
        });

        // another way
        try {
            integerList.get(-3);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.get(3);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> integerList.get(-1));
    }

    @Test
    public void testIterator_zeroElements() {
        Iterator<Integer> it = integerList.iterator();
        assertFalse(it.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> it.next());
    }

    @Test
    public void testIterator_severalElements() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);
        integerList.add(8);
        integerList.add(3);

        Iterator<Integer> it = integerList.iterator();

        int[] expected = {-7, -17, 5, 8, 3};
        int i = 0;

        //here we write the code which is the correct way to use iterator
        while (it.hasNext()) {
            int current = it.next();
            assertEquals(expected[i], current);
            i++;
        }
        assertEquals(5, i);
        assertThrows(IndexOutOfBoundsException.class, () -> it.next());
    }

    @Test
    public void testSort_severalElements() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);
        integerList.add(8);
        integerList.add(3);

        integerList.sort(new IntegerNaturalComparator());
        Iterator<Integer> it = integerList.iterator();

        int[] expected = {-17, -7, 3, 5, 8};
        int i = 0;

        //here we write the code which is the correct way to use iterator
        while (it.hasNext()) {
            int current = it.next();
            assertEquals(expected[i], current);
            i++;
        }
        assertEquals(5, i);
        assertThrows(IndexOutOfBoundsException.class, () -> it.next());
    }

    @Test
    public void testBackwardIterator_severalElements() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);
        integerList.add(8);
        integerList.add(3);

        Iterator<Integer> it = integerList.backwardIterator();

        int[] expected = {3, 8, 5, -17, -7};
        int i = 0;

        //here we write the code which is the correct way to use iterator
        while (it.hasNext()) {
            int current = it.next();
            assertEquals(expected[i], current);
            i++;
        }
        assertEquals(5, i);
        assertThrows(IndexOutOfBoundsException.class, () -> it.next());
    }

    @Test
    public void testBackwardIterator_zeroElements() {
        Iterator<Integer> it = integerList.backwardIterator();
        assertFalse(it.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> it.next());
    }

    @Test
    public void getMinNumber() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);
        integerList.add(8);
        integerList.add(3);
        int min = integerList.min(new IntegerNaturalComparator());
        assertEquals(min, -17);
    }
    @Test
    public void getMaxNumber() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);
        integerList.add(8);
        integerList.add(3);
        int max = integerList.max(new IntegerNaturalComparator());
        assertEquals(max, 8);
    }

}
