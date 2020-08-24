package com.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int NUMBER_CREDITS = 20;

    public static void main(String[] args) throws InterruptedException {
        List<Result> results = new ArrayList<>();
        LoanIssuer masha = new LoanIssuer(100,
                200,
                "Masha",
                results,
                NUMBER_CREDITS);

        LoanIssuer petya = new LoanIssuer(200,
                300,
                "Petya",
                results,
                NUMBER_CREDITS);

        LoanIssuer vasya = new InspiredLoanIssuer(200,
                300,
                "Vasya",
                results,
                NUMBER_CREDITS,
                20,
                50,
                100);

        masha.start();
        petya.start();
        vasya.start();

        masha.join();
        petya.join();
        vasya.join();

        for (Result result : results) {
            String toPrint = String.format("The worker %s issued all credits for %d", result.getName(), result.getWorkingTime());
            System.out.println(toPrint);
        }
    }
}
