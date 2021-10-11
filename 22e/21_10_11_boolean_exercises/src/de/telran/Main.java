package de.telran;

public class Main {

    public static void main(String[] args) {

        boolean someBoolean = isDividedBy3AndPositive(14) && isNumberBetween100and200(99);
    }

    static boolean isDividedBy3AndPositive(int number) {
        System.out.println("Inside positive and 3 function");
        return number > 0 && number % 3 == 0;
    }

    static boolean isDividedBy5or7(int number) {
        return number % 5 == 0 || number % 7 == 0;
    }

    static boolean isNumberBetween100and200(int number) {
        System.out.println("Inside 100 and 200 function");
        return number >= 100 && number <= 200;
    }
}
