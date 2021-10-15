package de.telran;

public class Main {

    public static void main(String[] args) {
        printArithmeticalProgression(1, 10, 3);
        printDecreasingArithmeticalProgression(10, 1, 3);
        printNumbersDividedBy5or7or13(10);
        printNumbersDividedBy5or7or13(100);
        printNumbersDividedBy5or7or13(1000);
    }
    //Написать ф-ю, которая распечатывает все числа от A до B с шагом D (начиная с A), где A меньше , чем B

    /**
     * Prints all numbers between a and b with the step d, where a must be lower than b
     *
     * @param a
     * @param b
     * @param d
     */
    static void printArithmeticalProgression(int a, int b, int d) {
        int currentNumber = a;

        while (currentNumber <= b) {
            System.out.print(currentNumber + " ");
            currentNumber += d;
        }
        System.out.println();
    }

    /**
     * Prints all numbers between a and b with the step d, where a must be greater than b
     *
     * @param a
     * @param b
     * @param d
     */
    static void printDecreasingArithmeticalProgression(int a, int b, int d) {
        int currentNumber = a;

        while (currentNumber >= b) {
            System.out.print(currentNumber + " ");
            currentNumber -= d;
        }
        System.out.println();
    }

    static void printNumbersDividedBy5or7or13(int max) {
        int currentNumber = 1;

        while (currentNumber <= max) {
            if (currentNumber % 5 == 0 || currentNumber % 7 == 0 || currentNumber % 13 == 0) {
                System.out.print(currentNumber + " ");
            }
            currentNumber++;
        }
        System.out.println();
    }
}
