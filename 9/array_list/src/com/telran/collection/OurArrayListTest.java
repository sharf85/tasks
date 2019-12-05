package com.telran.collection;

import com.telran.comparator.AbstractComparator;
import com.telran.comparator.IntegerComparator;
import org.junit.Test;

import static org.junit.Assert.*;

public class OurArrayListTest {

    @Test
    public void testAddGet_emptyObject_addsOneElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);

        assertEquals(5, list.get(0));
    }

    @Test
    public void testAddGet_emptyObject_addsSeveralElement() {
        OurArrayList list = new OurArrayList();

        Integer[] expected = {1, 3, -10, 18, 4, 3, 7, 1, 3, 3, 3, 5, 5, 10, -18, 22, 28, 60, 15, 20};
        for (int i = 0; i < expected.length; i++) {
            list.add(expected[i]);
        }

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
    }

    @Test
    public void testSize_emptyObject_addsOneElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);

        assertEquals(1, list.size());
    }

    @Test
    public void testSize_emptyObject_addsSeveralElement() {
        OurArrayList list = new OurArrayList();

        Integer[] expected = {1, 3, -10, 18, 4, 3, 7, 1, 3, 3, 3, 5, 5, 10, -18, 22, 28, 60, 15, 20};
        for (int i = 0; i < expected.length; i++) {
            list.add(expected[i]);
        }

        assertEquals(expected.length, list.size());
    }

    @Test
    public void testSet_oneElement_swapsElement() {
        OurArrayList list = new OurArrayList();
        list.add(0);
        list.set(0, 10);

        assertEquals(10, list.get(0));
    }

    @Test
    public void testSet_severalElement_swapsFirstLastMiddleElements() {
        OurArrayList list = new OurArrayList();

        Integer[] source = {1, 3, -10, 18, 4};
        for (int i = 0; i < source.length; i++) {
            list.add(source[i]);
        }

        list.set(0, 10);
        list.set(4, 5);
        list.set(2, -5);

        Integer[] expected = {10, 3, -5, 18, 5};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_nonEmptyObject_takeOuterElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);

        list.get(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet_nonEmptyObject_putOuterElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);

        list.set(4, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveById_nonEmptyObject_removesOuterElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);

        list.removeById(4);
    }

    @Test
    public void testRemoveById_nonEmptyObject_removesFirstElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);
        list.add(17);
        list.add(20);

        Object object = list.removeById(0);
        assertEquals(5, object);

        Integer[] expected = {15, 2, 5, 17, 20};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removesMiddleElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);
        list.add(17);
        list.add(20);

        Object object = list.removeById(2);
        assertEquals(2, object);

        Integer[] expected = {5, 15, 5, 17, 20};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removesLastElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);
        list.add(17);
        list.add(20);

        Object object = list.removeById(5);
        assertEquals(20, object);

        Integer[] expected = {5, 15, 2, 5, 17};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
    }

    @Test
    public void testMax_severalIntegers() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);

        AbstractComparator comparator = new IntegerComparator();

        assertEquals(15, list.max(comparator));
    }

    @Test
    public void testSort_severalIntegers() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);

        AbstractComparator comparator = new IntegerComparator();
        list.sort(comparator);
        int[] expected = {2, 5, 5, 15};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

    }

}