package de.telran;

public class Main {

    public static void main(String[] args) {
        printArithmeticalProgression(1, 15, 3);
        printArithmeticalProgression(1, 15, 4);
        printArithmeticalProgression(1, 16, 5);

        printDecreasingArithmeticalProgression(15, 1, 3);
        printDecreasingArithmeticalProgression(15, 1, 4);
        printDecreasingArithmeticalProgression(16, 1, 5);

        int sum = sumProgression(1, 10, 1);//55
        System.out.println(sum);

        printNumbersUpToMax(100);
        printNumbersUpToMax(50);
    }

    //Написать функцию, которая распечатывает все числа от A до B с щагом D.
    //(функция принимает три аргумента: A, B, D, причем A < B и D > 0)

    /**
     * The method prints out all numbers from a to b with the step d
     *
     * @param a starting point
     * @param b the greatest possible number. Must be greater than a. Otherwise the behavior of the method unpredictable
     * @param d the step. Must be positive. Otherwise the behavior of the method unpredictable
     */
    static void printArithmeticalProgression(int a, int b, int d) {
        int currentNumber = a;
        while (currentNumber <= b) {
            System.out.print(currentNumber + " ");
            currentNumber += d;
        }
        System.out.println();
    }

    //Написать функцию, которая распечатывает все числа от A до B с щагом D.
    //(функция принимает три аргумента: A, B, D, причем A > B и D > 0)

    /**
     * The method prints out all numbers from a down to b with the step d
     *
     * @param a starting point
     * @param b the least possible number. Must be lower than a. Otherwise the behavior of the method unpredictable
     * @param d the step. Must be positive. Otherwise the behavior of the method unpredictable
     */
    static void printDecreasingArithmeticalProgression(int a, int b, int d) {
        int currentNumber = a;
        while (currentNumber >= b) {
            System.out.print(currentNumber + " ");
            currentNumber -= d;
        }
        System.out.println();
    }


    //Написать функцию, которая считает (отдает, возвращает - return) сумму чисел от A до B с шагом D.
    //(функция принимает три аргумента: A, B, D, причем A < B и D > 0)
    static int sumProgression(int a, int b, int d) {
        int currentNumber = a;
        int sum = 0;

        while (currentNumber <= b) {
            sum += currentNumber;
            currentNumber += d;
        }

        return sum;
    }

    //Написать функцию, которая распечатывает все числа от 1 до A, кратные 5, 7 или 13 (которые делятся на одно из этих чисел).
    static void printNumbersUpToMax(int max) {
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
