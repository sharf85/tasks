package com.telran.performance_test;

import com.telran.collection.OurLinkedList;
import com.telran.collection.OurList;

import java.util.Random;

public class LinkedListOperationsStrategy implements ListOperationsStrategy {

    private static final Object object = 10;
    private Random rnd = new Random();

    @Override
    public void append(int nTimes) {
        OurList list = new OurLinkedList();

        for (int i = 0; i < nTimes; i++) {
            list.append(object);
        }

    }

    @Override
    public OurList getFilledList(int length) {
        OurList list = new OurLinkedList();

        for (int i = 0; i < length; i++) {
            list.append(object);
        }
        return list;
    }

    @Override
    public void get(int nTimes, OurList list) {
        int length = list.size();
        for (int i = 0; i < nTimes; i++) {
            list.get(rnd.nextInt(length));
        }
    }
}
