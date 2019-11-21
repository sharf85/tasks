package com.company.collection;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedNumbersListTest {


    private SortedNumbersList listTest;
    private SortedNumbersList list2Test;

    private int array1[];
    private int array2[];

    @Before
    public void init() {
        array1 = new int[]{19, 8, -6, 34, 55};
        listTest = new SortedNumbersList(array1);

        array2 = new int[]{-6, 8, 34, 0, 5, -20};
        list2Test = new SortedNumbersList(array2);
    }

    @Test
    public void size() {
        assertEquals(array1.length, listTest.size());
    }

    @Test
    public void get() {
        ArrayUtils.selectionSort(array1);

        for (int i = 0; i < array1.length; i++)
            assertEquals(array1[i], listTest.get(i));
    }


    @Test
    public void isRemove() {
        for (int i = 0; i < listTest.size(); i++) {
            listTest.isRemove(i);
            assertTrue(listTest.isContains(listTest.get(i)));
        }
    }


    @Test
    public void isContains() {
        for (int i = 0; i < listTest.size(); i++) {
            assertTrue(listTest.isContains(listTest.get(i)));
        }
    }

    @Test
    public void removeById() {
        ArrayUtils.selectionSort(array1);

        for (int i = 0; i < listTest.size(); i++) {
            listTest.removeById(0);
            assertTrue(listTest.get(0) != array1[0]);
        }
    }


    @Test
    public void displayToString() {
        listTest.displayToString();
    }

    @Test
    public void add() {
        listTest.add(150);
        assertTrue(listTest.isContains(150));
    }

    @Test
    public void removeRepeated() {
        //sortArray =    {-6, 8, 19, 19, 34}

        listTest.removeRepeated();
        assertTrue(listTest.get(3) != 19);
    }

    // list  = {-6, 8, 19, 19, 34}
    // list2 = {-6, 8, 34, 0, 5, -20}

    @Test
    public void intersection() {

        SortedNumbersList listC = listTest.intersection(list2Test);
        assertEquals(listC.size(), 3);
    }

    @Test
    public void union() {
        SortedNumbersList listC = listTest.union(list2Test);
        assertEquals(listC.size(), listTest.size() + list2Test.size());
    }
}





