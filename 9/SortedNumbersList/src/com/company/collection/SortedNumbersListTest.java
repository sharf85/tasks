package com.company.collection;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedNumbersListTest {


    SortedNumbersList list;
    SortedNumbersList list2;


    @Before
    public void init() {
        list = new SortedNumbersList(new int[]{19, 8, -6, 34, 19});
        list2 = new SortedNumbersList(new int[]{-6, 8, 34, 0, 5, -20});
    }

    @Test
    public void size() {
        assertEquals(5, list.size());
    }

    @Test
    public void get() {
        int testArray[] = new int[]{-6, 8, 19, 19, 34};
        for (int i = 0; i < list.size(); i++) {
            assertEquals(testArray[i], list.get(i));
        }
    }


    @Test
    public void isRemove() {
        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.isRemove(list.get(i)));
        }
    }


    @Test
    public void isContains() {
        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.isContains(list.get(i)));
        }
    }

    @Test
    public void removeById() {
        //array = {19, 8, -6, 34, 19};
        int[] arrayTwo = {-6, 8, 19, 19, 34};

        for (int i = 0; i < list.size(); i++) {
            list.removeById(0);
            assertTrue(list.get(0) != arrayTwo[0]);
        }
    }

//    @Test
//    public void display() {
//    }
//
//    @Test
//    public void displayToString() {
//    }

    @Test
    public void add() {
        //array = {19, 8, -6, 34, 19};
        int[] arrayTwo = {-6, 8, 19, 19, 34};

        list.add(150);
        assertTrue(list.isContains(150));
    }

    @Test
    public void removeRepeated() {
        //sortArray =    {-6, 8, 19, 19, 34}

        list.removeRepeated();
        assertTrue(list.get(3) != 19);
    }

    // list  = {-6, 8, 19, 19, 34}
    // list2 = {-6, 8, 34, 0, 5, -20}

    @Test
    public void intersection() {

        SortedNumbersList listC = list.intersection(list2);
        assertTrue(listC.size() == 3);
    }

    @Test
    public void union() {
        SortedNumbersList listC = list.union(list2);
        assertTrue(listC.size() == list.size() + list2.size());
    }
}





