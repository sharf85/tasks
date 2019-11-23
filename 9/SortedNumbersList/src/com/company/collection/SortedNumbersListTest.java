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
        System.out.println("array size: " + array1.length);
        assertEquals(5, listTest.size());
    }

    @Test
    public void get() {
        ArrayUtils.selectionSort(array1);
        System.out.println("array for get:");
        listTest.displayToString();

        for (int i = 0; i < array1.length; i++) {
            assertEquals(array1[i], listTest.get(i));
            System.out.println("array get intex: " + i + " array element is " + array1[i]);
        }
    }


    @Test
    public void isRemove() {

        listTest.isRemove(-6);
        assertFalse(listTest.isContains(-6));

        listTest.isRemove(8);
        assertFalse(listTest.isContains(8));

        listTest.isRemove(19);
        assertFalse(listTest.isContains(19));

        listTest.isRemove(34);
        assertFalse(listTest.isContains(34));

        listTest.isRemove(55);
        assertFalse(listTest.isContains(55));
    }


    @Test
    public void isContains() {
        System.out.println("array for isContains:");
        listTest.displayToString();

        assertEquals(true, listTest.isContains(-6));
        System.out.println("removed -6");

        assertEquals(true, listTest.isContains(8));
        System.out.println("removed 8");

        assertEquals(true, listTest.isContains(19));
        System.out.println("removed 19");

        assertEquals(false, listTest.isContains(20));
        System.out.println("removed 20");

        assertEquals(false, listTest.isContains(40));
        System.out.println("removed 40");

        assertEquals(false, listTest.isContains(555));
        System.out.println("removed 555");

    }

    @Test
    public void removeById() {
        listTest.displayToString();

        listTest.removeById(0);
        assertFalse(listTest.isContains(-6));
        System.out.println("removeById step 0");

        listTest.removeById(0);
        assertFalse(listTest.isContains(8));
        System.out.println("removeById step 1");

        listTest.removeById(0);
        assertFalse(listTest.isContains(19));
        System.out.println("removeById step 2");

        listTest.removeById(0);
        assertFalse(listTest.isContains(34));
        System.out.println("removeById step 3");

        listTest.displayToString();
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
        //sortArray =    {-6, 8, 19, 34}
        int[] arrayRemoveRepeated = {-6, 8, 19, 34};

        listTest.removeRepeated();

        assertTrue(arrayRemoveRepeated != this.array1);
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





