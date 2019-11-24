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
    public void testSize() {
        System.out.println("array size: " + array1.length);
        assertEquals(5, listTest.size());
    }

    @Test
    public void testGet() {
        ArrayUtils.selectionSort(array1);
        System.out.println("array for get:");
        listTest.displayToString();

        for (int i = 0; i < array1.length; i++) {
            assertEquals(array1[i], listTest.get(i));
            System.out.println("array get intex: " + i + " array element is " + array1[i]);
        }
    }


    @Test
    public void testRemove() {

        listTest.Remove(-6);
        assertFalse(listTest.contains(-6));
        listTest.Remove(8);
        assertFalse(listTest.contains(8));
        listTest.Remove(19);
        assertFalse(listTest.contains(19));
        listTest.Remove(34);
        assertFalse(listTest.contains(34));
        listTest.Remove(55);
        assertFalse(listTest.contains(55));
    }


    @Test
    public void testContains() {
        System.out.println("array for isContains:");
        listTest.displayToString();

        assertEquals(true, listTest.contains(-6));
        System.out.println("removed -6");
        assertEquals(true, listTest.contains(8));
        System.out.println("removed 8");
        assertEquals(true, listTest.contains(19));
        System.out.println("removed 19");
        assertEquals(false, listTest.contains(20));
        System.out.println("removed 20");
        assertEquals(false, listTest.contains(40));
        System.out.println("removed 40");
        assertEquals(false, listTest.contains(555));
        System.out.println("removed 555");

    }

    @Test
    public void testRemoveById() {
        listTest.displayToString();

        listTest.removeById(0);
        assertFalse(listTest.contains(-6));
        System.out.println("removeById step 0");
        listTest.removeById(0);
        assertFalse(listTest.contains(8));
        System.out.println("removeById step 1");
        listTest.removeById(0);
        assertFalse(listTest.contains(19));
        System.out.println("removeById step 2");
        listTest.removeById(0);
        assertFalse(listTest.contains(34));
        System.out.println("removeById step 3");
        listTest.displayToString();
    }


    @Test
    public void testDisplayToString() {
        listTest.displayToString();
    }

    @Test
    public void testAdd() {
        listTest.add(150);
        assertTrue(listTest.contains(150));
    }

    @Test
    public void testRemoveRepeated() {
        //sortArray =    {-6, 8, 19, 19, 34}
        //sortArray =    {-6, 8, 19, 34}
        int[] arrayRemoveRepeated = {-6, 8, 19, 34};

        listTest.removeRepeated();
        assertFalse(arrayRemoveRepeated == array1);
    }

    @Test
    public void testIntersection() {
        // list  = {-6, 8, 19, 19, 34}
        // list2 = {-6, 8, 34, 0, 5, -20}

        SortedNumbersList listC = listTest.intersection(list2Test);

        listTest.displayToString();
        list2Test.displayToString();
        System.out.println("result intersection");
        listC.displayToString();

        assertEquals(listC.size(), 3);
    }

    @Test
    public void testUnion() {
        SortedNumbersList listC = listTest.union(list2Test);
        int[] arrayUnion = {-20, -6, 0, 5, 8, 19, 34, 55};

        listTest.displayToString();
        list2Test.displayToString();
        System.out.println("result union without repeat elements");
        listC.displayToString();

        for (int i = 0; i < listC.size(); i++) {
            assertEquals(arrayUnion[i], listC.get(i));
        }
    }
}





