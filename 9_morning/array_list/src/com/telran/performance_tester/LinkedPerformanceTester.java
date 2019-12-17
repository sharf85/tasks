package com.telran.performance_tester;

import com.telran.collection.OurLinkedList;
import com.telran.collection.OurList;

public class LinkedPerformanceTester extends PerformanceTester {
    @Override
    protected OurList getEmptyList() {
        return new OurLinkedList();
    }

    @Override
    protected OurList makeList(int lengthList) {
        OurList list = new OurLinkedList();

        for (int i = 0; i < lengthList; i++) {
            list.append(o);
        }
        return list;
    }
}
