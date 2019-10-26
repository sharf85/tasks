package com.telran;

public class CycleFor {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        // equivalent
        int j = 0;
        while (j < 10) {
            System.out.println(j);
            j++;
        }

        int sum = 0;
        for (int i = 1; i < 88; i++) {
            sum += i;
        }
        // the same
        sum = 0;
        for (int i = 87; i > 0; i--) {
            sum += i;
        }
        System.out.println(sum);


//        home work
        // first assignment
        printDescendingNumbers(100, 10, 10);
        printDescendingNumbers(200, 100, 10);

        // second assignment: mult table
        printMultiplicationTable();

        // third assignment: sum of arithmetical progression
        int sumRange = getSumOfRange(1, 87, 1);
        System.out.println(sumRange);

        sum = getSumOfRange(5, 86, 3);
        System.out.println(sum);

        // numbers divided by 5, 7, 13
        printNumbersDividedBy5_7_13_toN(100);
        printNumbersDividedBy5_7_13_toN(1000);
    }


    private static void printNumbersDividedBy5_7_13_toN(int max) {
        int i = 1;
        while (i <= max) {
            if (i % 5 == 0 || i % 7 == 0 || i % 13 == 0) {
                System.out.print(i + " ");
            }
            i++;
        }
        System.out.println();
    }

    /**
     * The function print out all numbers from max to min with step
     *
     * @param max  maximum number
     * @param min  minimum number
     * @param step distance between numbers
     */
    static void printDescendingNumbers(int max, int min, int step) {
//        int currentNumber = max;
//        while (currentNumber >= min) {
//            System.out.println(currentNumber);
//            currentNumber -= step;
//        }

        for (int currentNumber = max; currentNumber >= min; currentNumber -= step) {
            System.out.println(currentNumber);
        }
    }

    static int getSumOfRange(int min, int max, int step) {
//        int sum = 0;
//        int currentNumber = min;
//        while (currentNumber <= max) {
//            sum += currentNumber;
//            currentNumber += step;
//        }
//        return sum;

        int sum = 0;

        for (int currentNumber = min; currentNumber <= max; currentNumber += step) {
            sum += currentNumber;
        }
        return sum;
    }

    //    static void printMultiplicationTable() {
//        int i = 1;
//        int j = 1;
//
//        while (i < 10) {
//            while (j < 10) {
//                System.out.print((i * j) + "\t");
//                j++;
//            }
//            i++;
//            j = 1;
//            System.out.println();
//        }
//    }
    static void printMultiplicationTable() {
//        int i = 1;
//        int j = 1;
//
//        while (i < 10) {
//            while (j < 10) {
//                System.out.print((i * j) + "\t");
//                j++;
//            }
//            i++;
//            j = 1;
//            System.out.println();
//        }

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

}
