package com.telran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        SqrtMaker sqrtMaker = new SqrtMaker();
        System.out.println(sqrtMaker.apply(10d));

        int a = 10, b = 15, c = 20;
        Function<Double, Double> f = (x) -> a * x * x + b * x + c;
        System.out.println(f.apply(3d));

        Function<List<Integer>, List<Integer>> uniqListMaker = (List<Integer> list) -> new ArrayList<>(new HashSet<>(list));
        System.out.println(uniqListMaker.apply(Arrays.asList(2, 5, 2, 3, 10, 5)));

        List<Integer> myList = new ArrayList<>() {
            {
                add(6);
            }

            @Override
            public String toString() {
                return "kuku";
            }
        };

        List<Integer> myListExplicit = new MyList();

        myList.add(1);
        myList.add(4);
        myList.add(2);
        myList.add(8);
        myList.add(1);

        myListExplicit.add(1);
        myListExplicit.add(4);
        myListExplicit.add(2);
        myListExplicit.add(8);
        myListExplicit.add(1);

        System.out.println(myList);
        System.out.println(myListExplicit);

        printResult(num -> num * num, 10);
        printResult(num -> num + 5, 10);

        Function<Integer, Integer> sqr = num -> {
            return num * num;
        };
        printResult(sqr, 3);

        myPrintResult(num -> num * num, 10);
        myPrintResult(num -> num + 5, 10);

        myPrintResult(sqr::apply, 3);
    }

    static void printResult(Function<Integer, Integer> function, int num) {
        int res = function.apply(num);
        System.out.println(res);
    }

    static void myPrintResult(MyFunction function, int num) {
        int res = function.compute(num);
        System.out.println(res);
    }
}

interface MyFunction {
    int compute(int num);
}

class SqrtMaker implements Function<Double, Double> {

    @Override
    public Double apply(Double num) {
        return Math.sqrt(num);
    }
}

class MyList extends ArrayList<Integer> {

    {
        add(4);
    }

    @Override
    public String toString() {
        return "ruku";
    }
}
