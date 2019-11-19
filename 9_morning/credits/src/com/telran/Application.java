package com.telran;

public class Application {

    private static double MASHA_VEL = 1;
    private static double PETR_VEL = 0.8;
    private static double LAZY_VASYA_VEL = 0.5;
    private static double MOTIVATED_VASYA_VEL = 1;
    // percents
    private static int VASYA_MOTIVATION_BORDER = 80;

    public static void main(String[] args) {
        boolean planOnTime = isPlanOnTime(1150, 490);
        System.out.println(planOnTime);
    }

    private static boolean isPlanOnTime(int totalCredits, int mashaTotalCredits) {
        int firstPackCredits = totalCredits * VASYA_MOTIVATION_BORDER / 100;

        int mashaFirstPackCredits = (int) (firstPackCredits / (MASHA_VEL + PETR_VEL + LAZY_VASYA_VEL));
        int mashaRestCredits = mashaTotalCredits - mashaFirstPackCredits;

        int restCredits = (int) (mashaRestCredits * (MASHA_VEL + PETR_VEL + MOTIVATED_VASYA_VEL));

        return firstPackCredits + restCredits >= totalCredits;
    }


}
