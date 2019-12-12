package com.telran.comparator;

import com.telran.CountryCode;

public class CountryCodeComparator implements OurComparator {

    private IntComparator intComparator = new IntComparator();
//    private IntComparator intComparator;
//
//    public CountryCodeComparator() {
//        intComparator = new IntComparator();
//    }

    @Override
    public int compare(Object o1, Object o2) {
        CountryCode code1 = (CountryCode) o1;
        CountryCode code2 = (CountryCode) o2;
        return intComparator.compare(code1.getCode(), code2.getCode());
    }
}
