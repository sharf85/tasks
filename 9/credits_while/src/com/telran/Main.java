package com.telran;

public class Main {

    public static void main(String[] args) {
        int mashaPerMonth = 50;
        int petyaPerMonth = (4 * mashaPerMonth) / 5;
        int lazyVasyaPerMonth = mashaPerMonth / 2;
        int fastVasyaPerMonth = mashaPerMonth;

        int totalCredits = 0;
        int numMonth = 0;
        while (totalCredits < 2100) {
            numMonth++;
            if (totalCredits < 1370) {
                totalCredits += mashaPerMonth + petyaPerMonth + lazyVasyaPerMonth;
            } else {
                totalCredits += mashaPerMonth + petyaPerMonth + fastVasyaPerMonth;
            }
        }

        System.out.println(numMonth);
    }
}
