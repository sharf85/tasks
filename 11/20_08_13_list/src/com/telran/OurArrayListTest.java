package com.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OurArrayListTest {
    OurList<Integer> list;

    @BeforeEach
    void init() {
        list = new OurArrayList<>();
    }

    @Test
    void testAdd_oneE_size1_equalTo() {
        list.add(5);
        assertEquals(5, list.get(0));
        assertEquals(1, list.size());
        assertTrue(list.contains(5));
    }

    @Test
    void testAdd_onePoint_containsExistingPoint() {
        OurList<Point2D> pointList = new OurArrayList<>();
        pointList.add(new Point2D(1, 1));


        Point2D expected = new Point2D(1, 1);
        assertTrue(pointList.contains(expected));
    }

    @Test
    void testAdd_threeDifferentE_size3_equalTo() {
        list.add(16);
        list.add(5);
        list.add(0);
        assertEquals(16, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(0, list.get(2));
        assertEquals(3, list.size());
        assertTrue(list.contains(16));
        assertTrue(list.contains(5));
        assertTrue(list.contains(0));
        assertFalse(list.contains(100));
    }

    @Test
    void testAdd_1to100E_size100_equalTo() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100, list.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(i, list.get(i));
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(list.contains(i));
        }
    }

    @Test
    void testRemoveIndex_oneE_size0() {
        list.add(1);
        assertEquals(1, list.remove(0));
        assertEquals(0, list.size());
    }

    @Test
    void testRemoveIndex_threeDifferentElRemoveOne_size2_equalTo() {
        list.add(16);
        list.add(5);
        list.add(671);
        assertEquals(671, list.remove(2));
        assertEquals(2, list.size());
        assertFalse(list.contains(671));
    }

    @Test
    void testRemoveIndex_100DifferentElRemove100_size0() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0, j = 99; i < 99; i++, j--) {
            assertEquals(i, list.remove(0));
            assertEquals(j, list.size());
        }
    }

    @Test
    void testRemove_16consistentNumbers_RemoveIndex15() {
        for (int i = 0; i < 16; i++) {
            list.add(i);
        }
        int res = list.remove(15);
        assertEquals(15, res);
    }

    @Test
    void testRemoveIndex_IndexOutOfBoundException() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void testGet_oneE_equalTo() {
        list.add(88);
        assertEquals(88, list.get(0));
    }

    @Test
    void testGet_threeE_equalTo() {
        list.add(88);
        list.add(17);
        list.add(910);
        assertEquals(910, list.get(2));
    }

    @Test
    void testGet_IndexOutOfBoundsException() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    public void testArrayIterator() {

        list.add(2);
        list.add(-1);
        list.add(23);
        list.add(4);
        list.add(89);

        int[] expected = {2, -1, 23, 4, 89};

        Iterator<Integer> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            int num = it.next();
            assertEquals(expected[i++], num);
        }

    }

    @Test
    public void testSort_add16elt_9() {

        list.add(15);
        list.add(16);
        list.add(11);
        list.add(3);
        list.add(12);
        list.add(14);
        list.add(1);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(13);
        list.add(10);
        list.add(2);

        list.sort();
        assertEquals(9, list.get(8));
    }

    @Test
    void testSortWithComparator_Point2DList_sortedList() {
        OurList<Point2D> expected = new OurArrayList<>();
        expected.add(new Point2D(0, 1));
        expected.add(new Point2D(1, 1));
        expected.add(new Point2D(4, 4));
        expected.add(new Point2D(3, 7));
        expected.add(new Point2D(16, 3));

        OurList<Point2D> pointList = new OurArrayList<>();
        pointList.add(new Point2D(4, 4));
        pointList.add(new Point2D(1, 1));
        pointList.add(new Point2D(0, 1));
        pointList.add(new Point2D(16, 3));
        pointList.add(new Point2D(3, 7));

        pointList.sort(new Point2DComparator());
        for (int i = 0; i < pointList.size(); i++) {
            assertEquals(expected.get(i), pointList.get(i));
        }
    }
}
