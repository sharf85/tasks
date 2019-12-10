package com.telran.comparator;

public class IntComparator implements OurComparator {
    @Override
    public int compare(Object o1, Object o2) {
        Integer left = (Integer) o1;
        Integer right = (Integer) o2;

        if (left < right)
            return -1;
        if (left > right)
            return 1;
        return 0;
    }
}
