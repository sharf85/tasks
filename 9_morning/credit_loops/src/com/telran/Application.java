package com.telran;

public class Application {

    public static void main(String[] args) {
        // write your code here

        System.out.println(countMonths());

        System.out.println(countCredits());
    }

    public static int countMonths() {
        int mashaPerMonth = 50;
        int petyaPerMonth = 50 * 4 / 5;
        int lazyVasyaPerMonth = 50 / 2;

        int motivatedVasyaPerMonth = mashaPerMonth;

        int vasyaMotivationPoint = 1370;
        int totalCredits = 2100;

        int countMonth = 0;
        int providedCredits = 0;

        while (providedCredits < vasyaMotivationPoint) {
            providedCredits += mashaPerMonth + petyaPerMonth + lazyVasyaPerMonth;
            countMonth++;
        }

        while (providedCredits < totalCredits) {
            providedCredits += mashaPerMonth + petyaPerMonth + motivatedVasyaPerMonth;
            countMonth++;
        }
        return countMonth;
    }

    public static int countCredits() {
        int totalTime = 18;
        int vasyaMotivationPoint = 10;

        final int initialVasyaPerMonth = 50;
        int mashaPerMonth = 50;
        int petyaPerMonth = 40;
        int vasyaPerMonth = 50;

        int totalCredits = 0;
        for (int i = 0; i < totalTime; i++) {
            System.out.println(vasyaPerMonth + " " + petyaPerMonth);
            totalCredits += mashaPerMonth + petyaPerMonth + vasyaPerMonth;

            mashaPerMonth++;

            if (i % 2 == 1)
                petyaPerMonth++;

            if (i < vasyaMotivationPoint - 1) {
                vasyaPerMonth--;
            } else {
                vasyaPerMonth = initialVasyaPerMonth;
            }
        }

        return totalCredits;
    }

    public static int countCreditsIssued(int lastCreditNumber) {
        int res = 0;

        for (int currentNumber = 1; currentNumber <= lastCreditNumber; currentNumber++) {
            if (currentNumber % 13 == 0)
                continue;

            if (currentNumber % 3 == 0)
                System.out.println("The loan number " + currentNumber + " was issued by Masha");
            else if (currentNumber % 3 == 1)
                System.out.println("The loan number " + currentNumber + " was issued Petr");
            else
                System.out.println("The loan number " + currentNumber + " was issued Vasya");

            res++;
        }

        return res;
    }
}
