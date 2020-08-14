package com.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertEquals(5,list.get(0));
        assertEquals(1,list.size());
        assertTrue(list.contains(5));
    }

    @Test
    void testAdd_threeDifferentE_size3_equalTo() {
        list.add(16);
        list.add(5);
        list.add(0);
        assertEquals(16,list.get(0));
        assertEquals(5,list.get(1));
        assertEquals(0,list.get(2));
        assertEquals(3,list.size());
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
        assertEquals(100,list.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(i,list.get(i));
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(list.contains(i));
        }
    }

    @Test
    void testRemoveIndex_oneE_size0() {
        list.add(1);
        assertEquals(1,list.remove(0));
        assertEquals(0,list.size());
    }

    @Test
    void testRemoveIndex_threeDifferentElRemoveOne_size2_equalTo() {
        list.add(16);
        list.add(5);
        list.add(671);
        assertEquals(671,list.remove(2));
        assertEquals(2,list.size());
        assertFalse(list.contains(671));
    }

    @Test
    void testRemoveIndex_100DifferentElRemove100_size0() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0, j = 99; i < 99; i++, j--) {
            assertEquals(i,list.remove(0));
            assertEquals(j,list.size());
        }
    }

    @Test
    void testRemove16E_RemoveIndex15() {
        for (int i = 0; i < 16; i++) {
            list.add(i);
        }
        assertEquals(15,list.remove(15));

    }

    @Test
    void testRemoveIndex_IndexOutOfBoundException() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void testGet_oneE_equalTo() {
        list.add(88);
        assertEquals(88,list.get(0));
    }

    @Test
    void testGet_threeE_equalTo() {
        list.add(88);
        list.add(17);
        list.add(910);
        assertEquals(910,list.get(2));
    }

    @Test
    void testGet_IndexOutOfBoundsException() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class,() -> list.get(1));
    }
}
