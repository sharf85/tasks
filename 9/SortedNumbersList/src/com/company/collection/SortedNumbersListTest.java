package com.company.collection;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedNumbersListTest {


    SortedNumbersList list;
    SortedNumbersList listIsRemoved;
    SortedNumbersList listRemoved;
    SortedNumbersList listRemovedRepeat;
    int[] array;

    @Before
    public void init() {
        array = new int[]{19, 8, -6, 34, 19};
        list = new SortedNumbersList(array);
        listIsRemoved = new SortedNumbersList(array);
        listRemoved = new SortedNumbersList(array);
        listRemovedRepeat = new SortedNumbersList(array);
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
        for (int i = 0; i < listIsRemoved.size(); i++) {
            assertTrue(listIsRemoved.isRemove(list.get(i)));
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

        for (int i = 0; i < listRemoved.size(); i++) {
            listRemoved.removeById(0);
            assertTrue(listRemoved.get(0) != arrayTwo[0]);
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
        //array = {19, 8, -6, 34, 19};
        int[] arrayTwo = {-6, 8, 19, 19, 34};

        listRemovedRepeat.removeRepeated();
        assertTrue(listRemovedRepeat.get(3) != 19);
    }


    @Test
    public void intersection() {

    }

    @Test
    public void union() {
    }
}





