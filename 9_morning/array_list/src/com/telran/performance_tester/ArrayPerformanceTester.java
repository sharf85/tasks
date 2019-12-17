package com.telran.performance_tester;

import com.telran.collection.OurArrayList;
import com.telran.collection.OurList;

public class ArrayPerformanceTester extends PerformanceTester {
    @Override
    protected OurList getEmptyList() {
        return new OurArrayList();
    }

    /**
     * makes an OurArrayList with the same elements of the length lengthList
     *
     * @param lengthList the length of the returning list
     * @return new OurArrayList of length lengthList
     */
    @Override
    protected OurList makeList(int lengthList) {
        OurList list = new OurArrayList();
        for (int i = 0; i < lengthList; i++) {
            list.append(o);
        }
        return list;
    }
}
