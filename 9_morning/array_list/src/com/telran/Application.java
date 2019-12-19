package com.telran;

import com.telran.collection.OurList;
import com.telran.collection.OurArrayList;
import com.telran.comparator.CountryCodeComparator;
import com.telran.comparator.OurComparator;
import com.telran.performance_tester.ArrayPerformanceTester;
import com.telran.performance_tester.LinkedPerformanceTester;
import com.telran.performance_tester.PerformanceTester;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Application {

    public static void main(String[] args) {

//        example for removal
//        OurArrayList list = createListOfHumans();
//
//        Human anotherVasya = new Human("Vasily", 20);
//
//        list.remove(anotherVasya);//false
//        System.out.println(list.size());

        //example for comparator
//        OurComparator countryCodeComparator = new CountryCodeComparator();
//        OurArrayList countryCodes = new OurArrayList();
//
//        fillCountryCodes(countryCodes);
//        System.out.println(countryCodes.max(countryCodeComparator));
//        System.out.println(countryCodes.min(countryCodeComparator));
//
//        countryCodes.sort(countryCodeComparator);
//        for (int i = 0; i < countryCodes.size(); i++) {
//            System.out.println(countryCodes.get(i));
//        }

//        example for performance testing

        PerformanceTester arrayTester = new ArrayPerformanceTester();
        PerformanceTester linkedTester = new LinkedPerformanceTester();

//        System.out.println(arrayTester.testAppend(10000000));
//        System.out.println(linkedTester.testAppend(10000000));

//        System.out.println(arrayTester.testGet(10000, 10000));
//        System.out.println(linkedTester.testGet(10000, 10000));

        System.out.println(arrayTester.testRemoveFirst(10000, 1000000));
        System.out.println(linkedTester.testRemoveFirst(10000, 1000000));

    }

    private static void fillCountryCodes(OurList countryCodes) {
        CountryCode usa = new CountryCode("USA", 1);
        CountryCode russia = new CountryCode("Russia", 7);
        CountryCode germany = new CountryCode("Germany", 49);
        CountryCode israel = new CountryCode("Israel", 972);

        countryCodes.append(germany);
        countryCodes.append(israel);
        countryCodes.append(russia);
        countryCodes.append(usa);
    }

    private static OurArrayList createListOfHumans() {
        Human vasya = new Human("Vasily", 20);
        Human petya = new Human("Petr", 21);
        Human masha = new Human("Maria", 22);

        OurArrayList list = new OurArrayList();
        list.append(vasya);
        list.append(petya);
        list.append(masha);
        return list;
    }


}
