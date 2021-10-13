package de.telran;

public class Main {

    public static void main(String[] args) {
        int number = 239;

        boolean someBoolean = isDividedBy3andPositive(number) & isDividedBy5or7(number);

        if (isDividedBy3andPositive(number) & isDividedBy5or7(number)) {

        }
    }

    //написать функцию, которая определяет, делится ли число на 3 и при этом положительное (>0)
    static boolean isDividedBy3andPositive(int number) {
        System.out.println("Inside isDividedBy3andPositive()");
        return number % 3 == 0 && number > 0;
    }

    //--"-- делится ли число на 5 ИЛИ на 7.
    static boolean isDividedBy5or7(int number) {
        System.out.println("Inside isDividedBy5or7()");
        return number % 5 == 0 || number % 7 == 0;
    }

    //--"-- находится ли целое число в промежутка от 100 до 200 (включительно) и при этом четное
    static boolean isEvenAndBetween100and200(int number) {
        return number >= 100 && number <= 200 && number % 2 == 0;
    }
}
