package com.telran;

import com.telran.collection.OurArrayList;

public class Application {

    public static void main(String[] args) {
        OurArrayList list = new OurArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(new Integer(i));
        }
        System.out.println();
    }
}
