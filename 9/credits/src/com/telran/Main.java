package com.telran;

public class Main {

    public static void main(String[] args) {
        int totalAmount = 1150;
        int totalMashaCredits = 450;

        int givenCreditsWhileVasyaLazy = (int) (1150 * 0.8);

        double mashaVelocity = 1;
        double petyaVelocity = 0.8;
        double lazyVasyaVelocity = 0.5;
        double motivatedVasyaVelocity = 1;
// the summary velocity of Masha, Petya and Vasya int the very beginning
        double totalInitialVelocity = mashaVelocity + petyaVelocity + lazyVasyaVelocity;
// the amount of credits given by Masha until 80% of the annual plan
        int mashaGivenInitialCredits = (int) (givenCreditsWhileVasyaLazy / totalInitialVelocity);

        int remainingMashaCredits = totalMashaCredits - mashaGivenInitialCredits;// remaining 50 credits

        double totalVelocityWithMotivatedVasya = mashaVelocity + petyaVelocity + motivatedVasyaVelocity;

        int totalCreditsGiven = givenCreditsWhileVasyaLazy
                + (int) (totalVelocityWithMotivatedVasya * remainingMashaCredits);
    }
}
