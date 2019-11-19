package com.telran;

public class Application {

    public static void main(String[] args) {
        boolean isVasyaFishing = toGoFishing(20, 5);
    }

    private static boolean toGoFishing(double temp, int dayOfWeek) {
        if (dayOfWeek == 4 && temp >= 19 && temp <= 23) {
            return true;
        }

        return false;
    }
}
