package de.telran;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    static void printArithmeticalProgression(int a, int b, int d) {
        for (int i = a; i <= b; i += d) {
            System.out.print(i + " ");
        }
    }

    static void printDescendingArithmeticalProgression(int a, int b, int d) {
        for (int i = a; i >= b; i -= d) {
            System.out.print(i + " ");
        }
    }

    static int sumArithmeticalProgression(int a, int b, int d) {
        int sum = 0;
        for (int i = a; i <= b; i += d) {
            sum += i;
        }
        return sum;
    }

    static void printNumbers(int max) {
        for (int i = 1; i <= max; i++) {
            if (i % 5 == 0 || i % 7 == 0 || i % 13 == 0)
                System.out.print(i + " ");
        }
    }
}
