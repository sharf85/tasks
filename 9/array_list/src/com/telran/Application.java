package com.telran;

import com.telran.collection.OurArrayList;
import com.telran.performance_test.ArrayListOperationsStrategy;
import com.telran.performance_test.LinkedListOperationsStrategy;
import com.telran.performance_test.ListOperationsStrategy;
import com.telran.performance_test.ListPerformanceTester;

public class Application {

    public static void main(String[] args) {
        ListOperationsStrategy arrayStrategy = new ArrayListOperationsStrategy();
        ListOperationsStrategy linkedStrategy = new LinkedListOperationsStrategy();


        ListPerformanceTester arrayTester = new ListPerformanceTester(arrayStrategy);
        ListPerformanceTester linkedTester = new ListPerformanceTester(linkedStrategy);

        System.out.println(arrayTester.testAppendPerformance(10000000));
        System.out.println(linkedTester.testAppendPerformance(10000000));

        System.out.println(arrayTester.testGetPerformance(1000000, 1000));
        System.out.println(linkedTester.testGetPerformance(1000000, 1000));
    }

    static OurArrayList makeHumanList() {
        Human vasya = new Human("Vasya", 20);
        Human petya = new Human("Petya", 20);
        Human masha = new Human("Masha", 20);

        OurArrayList res = new OurArrayList();
        res.append(vasya);
        res.append(petya);
        res.append(masha);
        return res;
    }

}
