package com.telran.performance_tester;

import com.telran.collection.OurList;

import java.util.Random;

public abstract class PerformanceTester {

    protected Object o = new Object();

    public long testAppend(int n) {
        OurList list = getEmptyList();
        long now = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.append(o);
        }
        return System.currentTimeMillis() - now;
    }

    public long testGet(int n, int lengthList) {
        OurList list = makeList(lengthList);
        long now = System.currentTimeMillis();

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            list.get(random.nextInt(lengthList));
        }
        return System.currentTimeMillis() - now;
    }

    public long testRemoveFirst(int n, int length) {
        OurList list = makeList(length);

        long now = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.removeById(0);
        }
        return System.currentTimeMillis() - now;
    }

    protected abstract OurList getEmptyList();

    protected abstract OurList makeList(int lengthList);
}
