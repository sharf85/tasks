package com.telran;

public class CreditsFor {

    public static void main(String[] args) {
        int mashaPerMonth = 50;
        int petyaPerMonth = 40;
        int vasyaPerMonth = 50;

        int totalCredits = 0;
        for (int i = 1; i <= 18; i++) {
            totalCredits += mashaPerMonth + petyaPerMonth + vasyaPerMonth;

            mashaPerMonth++;

            if (i % 2 == 0) {
                petyaPerMonth++;
            }

            if (i < 10) {
                vasyaPerMonth--;
            } else {
                vasyaPerMonth = 50;
            }
        }

        System.out.println(totalCredits);
    }
}
