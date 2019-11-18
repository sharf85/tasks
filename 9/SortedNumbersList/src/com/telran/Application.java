package com.telran;

import com.telran.collection.SortedNumbersList;

public class Application {

    public static void main(String[] args) {
        // write your code here
        int[] array = {};

        SortedNumbersList list = new SortedNumbersList(new int[]{19, 8, -6, 34});
        list.display();
        System.out.println(list.remove(8));
        list.display();
        System.out.println(list.remove(8));

        new SortedNumbersList().size();
//        SortedNumbersList list2 = new SortedNumbersList(new int[]{2, -5, -6});

//        SortedNumbersList list3 = list.intersection(list2);// {-6}
//        SortedNumbersList list4 = list.union(list2);// {-6, -5, 2, 8, 19, 34}
    }
}
