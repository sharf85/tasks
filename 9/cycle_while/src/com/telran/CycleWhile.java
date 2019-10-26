package com.telran;

public class CycleWhile {

    public static void main(String[] args) {
        // first assignment
        printDescendingNumbers(100, 10, 10);
        printDescendingNumbers(200, 100, 10);

        // second assignment: mult table
        printMultiplicationTable();

        // third assignment: sum of arithmetical progression
        int sum = getSumOfRange(1, 87, 1);
        System.out.println(sum);

        sum = getSumOfRange(5, 86, 3);
        System.out.println(sum);

        // numbers divided by 5, 7, 13
        printNumbersDividedBy5_7_13_toN(100);
        printNumbersDividedBy5_7_13_toN(1000);
        printNumbersDividedBy5_7_13_toN(5000);
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
        int currentNumber = max;
        while (currentNumber >= min) {
            System.out.println(currentNumber);
            currentNumber -= step;
        }
    }

    static int getSumOfRange(int min, int max, int step) {
        int sum = 0;
        int currentNumber = min;
        while (currentNumber <= max) {
            sum += currentNumber;
            currentNumber += step;
        }
        return sum;
    }

    static void printMultiplicationTable() {
        int i = 1;
        int j = 1;

        while (i < 10) {
            while (j < 10) {
                System.out.print((i * j) + "\t");
                j++;
            }
            i++;
            j = 1;
            System.out.println();
        }
    }
}
