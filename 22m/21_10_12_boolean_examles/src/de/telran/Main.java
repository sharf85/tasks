package de.telran;

public class Main {

    public static void main(String[] args) {
        System.out.println(isDividedBy15(10));//false
        System.out.println(isDividedBy15(0));//true
        System.out.println(isDividedBy15(15));//true
        System.out.println(isDividedBy15(45));//true
        System.out.println(isDividedBy15(37));//false

        System.out.println(isDividedBy15second(10));//false
        System.out.println(isDividedBy15second(0));//true
        System.out.println(isDividedBy15second(15));//true
        System.out.println(isDividedBy15second(45));//true
        System.out.println(isDividedBy15second(37));//false
    }

    static boolean isDividedBy15(int number) {
        int remainder = number % 15;
        boolean result = remainder == 0;
        return result;
//        return number % 15 == 0;
    }

    static boolean isDividedBy15second(int number) {
        boolean res = (number % 3 == 0) && (number % 5 == 0);
        return res;
//        return number % 15 == 0;
    }

}
