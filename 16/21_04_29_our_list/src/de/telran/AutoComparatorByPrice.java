package de.telran;

import java.util.Comparator;

public class AutoComparatorByPrice implements Comparator<Auto> {
    @Override
    public int compare(Auto auto1, Auto auto2) {
//        return Long.compare(o1.getPrice(), o2.getPrice());
        if (auto1.getPrice() < auto2.getPrice())
            return -1;//any negative number
        if (auto1.getPrice() > auto2.getPrice())
            return 1;//any positive number
        return 0;
    }
}
