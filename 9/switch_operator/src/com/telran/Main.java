package com.telran;

public class Main {

    public static void main(String[] args) {
        int dayOfWeek = -1;

        final int monday = 1;

        switch (dayOfWeek) {
            case monday:
                System.out.println("Monday");
            case 2:
            case 3:
                System.out.println("First half of a week");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Not a day of week");
        }

    }
}
