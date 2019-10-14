package com.telran;

public class Main {

    public static void main(String[] args) {
//        here one can plan with input variables
        int annualPlan = 1150;
        int totalMashaCredits = 490;

//        we call the function here
        int totalCreditsGiven = totalCreditsGiven(annualPlan, totalMashaCredits);

        if (totalCreditsGiven >= annualPlan) {
            System.out.println("The guys succeed to complete the annual plan and gave " + totalCreditsGiven + " credits in total");
        } else {
            System.out.println("The guys did not complete the annual plan as they gave "
                    + totalCreditsGiven + " credits in total");
        }

    }

    static int totalCreditsGiven(int annualPlan, int totalMashaCredits) {
        int givenCreditsWhileVasyaLazy = (int) (annualPlan * 0.8);

        final double mashaVelocity = 1;
        final double petyaVelocity = 0.8;
        final double lazyVasyaVelocity = 0.5;
        final double motivatedVasyaVelocity = 1;

// the summary velocity of Masha, Petya and Vasya int the very beginning
        double totalVelocityWhileVasyaLazy = mashaVelocity + petyaVelocity + lazyVasyaVelocity;
// the amount of credits given by Masha until 80% of the annual plan
        int mashaCreditsWhileVasyaLazy = (int) (givenCreditsWhileVasyaLazy / totalVelocityWhileVasyaLazy);

// the amount of credits given by Masha after Vasya became motivated
        int remainingMashaCredits = totalMashaCredits - mashaCreditsWhileVasyaLazy;

        double totalVelocityWithMotivatedVasya = mashaVelocity + petyaVelocity + motivatedVasyaVelocity;

        return givenCreditsWhileVasyaLazy
                + (int) (totalVelocityWithMotivatedVasya * remainingMashaCredits);
    }
}
