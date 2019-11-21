package com.company.collection;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedNumbersListTest {


    SortedNumbersList list;
    int[] array;

    @Before
    public void init() {
        array = new int[]{19, 8, -6, 34, 19};
        list = new SortedNumbersList(array);
    }

    @Test
    public void test_size() {
        assertEquals(5, list.size());
    }

    @Test
    public void test_getAllElements() {

        assertEquals(-6, list.get(0));
        assertEquals(8, list.get(1));
        assertEquals(19, list.get(2));
        assertEquals(34, list.get(3));
    }


    @Test
    public void isRemove() {
        assertTrue(list.isRemove(8));
    }


    @Test
    public void isContains() {
        assertTrue(list.isContains(8));
        assertTrue(list.isContains(19));

    }

    @Test
    public void removeById() {
        // -6, 8, 19, 19, 34
        int[] arrayTwo = {-6, 8, 19, 19, 34};

        for (int i = 0; i < list.size(); i++) {
            list.removeById(i);
            for (int j = 0; j < list.size(); j++) {
                assertTrue(list.isRemove(list.get(j)));
            }
        }
    }
}



