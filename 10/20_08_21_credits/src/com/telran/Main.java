package com.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Result> resultList = new ArrayList<>();
        Thread masha = new StandardEmployee(100,
                200,
                "Masha",
                20,
                resultList);
        Thread petya = new StandardEmployee(100,
                300,
                "Petya",
                20,
                resultList);
        Thread vasya = new LazyInspiredEmployee(200,
                300,
                "Vasya",
                20,
                resultList,
                50,
                100,
                30);

        masha.start();
        petya.start();
        vasya.start();

        masha.join();
        petya.join();
        vasya.join();

        for (Result result : resultList) {
            String toPrint = String.format("The employee %s completed the program for %d", result.name, result.duration);
            System.out.println(toPrint);
        }
    }
}
