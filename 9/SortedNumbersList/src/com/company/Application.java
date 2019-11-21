package com.company;

import com.company.collection.SortedNumbersList;


public class Application {


    public static void main(String[] args) {
        SortedNumbersList list1 = new SortedNumbersList(new int[]{-1, -2, -3, -4, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        SortedNumbersList list2 = new SortedNumbersList(new int[]{-20, 15, -90, 14, 7, -2, -5, 5, 6, -5, 12, 56, 78, 231, 96, 74, 6, -10, -20, 10});

        //display, displayToString
        //add
        System.out.println("add method");

        list1.displayToString();
        System.out.println("add number 11 to array : ");
        list1.add(11);
        list1.displayToString();

        System.out.println();

        //get
        System.out.println("get method");

        System.out.println("get id 2: " + list1.get(2));
        System.out.println("get id 2: " + list1.get(0));

        System.out.println();

        //size
        System.out.println("size method");

        System.out.println("array size : " + list1.size());

        System.out.println();

        //removeById
        System.out.println("removeById method");

        System.out.println("start array");
        list2.displayToString();

        System.out.println("remove in array id 1");
        list1.removeById(16);
        System.out.println("new array");
        list2.displayToString();

        System.out.println();

        //removeRepeated
        System.out.println("removeRepeated method");

        System.out.println();
        System.out.println("remove repeated, start array");
        list2.displayToString();
        System.out.println("remove repeated");
        list2.removeRepeated();
        list2.displayToString();

        System.out.println();

        //intersection
        SortedNumbersList listA = new SortedNumbersList(new int[]{-9, -8, -7, 5, 6});
        SortedNumbersList listB = new SortedNumbersList(new int[]{-9, -8, -7, 55, 66});

        System.out.println("intersection method");
        SortedNumbersList listC = listA.intersection(listB);

        listA.displayToString();
        listB.displayToString();
        listC.displayToString();

        System.out.println();

        //union
        System.out.println("union method");
        SortedNumbersList listD = new SortedNumbersList(new int[]{0, 1, 2, 3, 4, 5, 6});
        SortedNumbersList listE = new SortedNumbersList(new int[]{7, 8, 9, 10, 11, 12, 13, 14});

        SortedNumbersList listF = listD.union(listE);

        listD.displayToString();
        listE.displayToString();
        listF.displayToString();

        System.out.println();

        //isContains
        System.out.println("isContains method");

        System.out.println("isContains, start array");
        list2.displayToString();
        System.out.println("is contains 10? : " + list2.isContains(10));
        System.out.println("is contains 90? : " + list2.isContains(90));
    }
}