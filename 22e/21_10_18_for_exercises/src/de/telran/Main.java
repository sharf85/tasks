package de.telran;

public class Main {

    public static void main(String[] args) {
        int res = sumWhile(1, 10, 1);
        System.out.println(res);
        res = sumWhile(1, 10, 2);
        System.out.println(res);

        res = sumFor(1, 10, 1);
        System.out.println(res);
        res = sumFor(1, 10, 2);
        System.out.println(res);

        printArithmeticalProgressionFor(1, 10, 2);
        printDecreasingArithmeticalProgressionFor(10, 1, 3);

        printAllNumbersFor(100);
        printAllNumbersFor(50);
    }

    static int sumWhile(int a, int b, int d) {
        int sum = 0;
        int currentNumber = a;

        while (currentNumber <= b) {
            sum += currentNumber;
            currentNumber += d;
        }
        return sum;
    }

    static int sumFor(int a, int b, int d) {
        int sum = 0;

        for (int i = a; i <= b; i += d) {
            sum += i;
        }

        return sum;
    }

    static void printArithmeticalProgressionFor(int a, int b, int d) {
        for (int i = a; i <= b; i += d) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void printDecreasingArithmeticalProgressionFor(int a, int b, int d) {
        for (int i = a; i >= b; i -= d) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void printAllNumbersFor(int max) {
        for (int i = 1; i <= max; i++) {
            if (i % 5 == 0 || i % 7 == 0 || i % 13 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
