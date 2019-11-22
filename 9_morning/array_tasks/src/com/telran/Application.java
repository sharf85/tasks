package com.telran;

public class Application {

    public static void main(String[] args) {

        System.out.println(fib(0));//0
        System.out.println(fib(1));//1
        System.out.println(fib(2));//1
        System.out.println(fib(3));//2
        System.out.println(fib(4));//3
        System.out.println(fib(5));//5
        System.out.println(fib(6));//8
        System.out.println(fib(7));//13


        System.out.println(fibArray(0));//0
        System.out.println(fibArray(1));//1
        System.out.println(fibArray(2));//1
        System.out.println(fibArray(3));//2
        System.out.println(fibArray(4));//3
        System.out.println(fibArray(5));//5
        System.out.println(fibArray(6));//8
        System.out.println(fibArray(7));//13

    }

    public static boolean isOddNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1)
                return true;
        }

        return false;
    }

    public static int sumEvenElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                sum += array[i];
        }
        return sum;
    }

    public static int[] copyArrayTriplePositives(int[] array) {
        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0)
                newArray[i] = array[i] * 3;
            else
                newArray[i] = array[i];
        }

        return newArray;
    }

    public static void printNumbersDividedBy5_7_13() {
        for (int i = 1; i <= 1000; i++) {
            if (i % 5 == 0 || i % 7 == 0 || i % 13 == 0)
                System.out.println(i);
        }
    }

    public static int sumOddsBeforeN(int[] array, int N) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= N && array[i] % 2 == 1)
                sum += array[i];//sum = sum + array[i];
        }

        return sum;
    }

    public static int fib(int n) {
        if (n < 2)
            return n;

        int prev = 1;//f1
        int current = 1;//f2
        for (int i = 2; i < n; i++) {
            int next = current + prev;
            prev = current;
            current = next;
        }
        return current;
    }

    public static int fibArray(int n) {
        if (n < 1)
            return 0;

        int[] array = new int[n + 1];
        array[1] = 1;

        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];
    }

    public static int numberSubarraysWithPositives(int[][] array) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    counter++;
                    break;
                }
            }
        }

        return counter;
    }
}
