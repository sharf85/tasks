package com.telran.performance_test;

import com.telran.collection.OurList;

public interface ListOperationsStrategy {
    void append(int nTimes);

    OurList getFilledList(int length);

    void get(int nTimes, OurList list);
}
