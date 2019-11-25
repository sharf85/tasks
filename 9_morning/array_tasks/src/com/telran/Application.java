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

    public static int[][] createDoubleArray0_99() {
        int[][] res = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                res[i][j] = i * 10 + j;
            }
        }
        return res;
    }

    public static int[][] createDoubleArray99_0() {
        int[][] res = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                res[i][j] = (9 - i) * 10 + 9 - j;
            }
        }
        return res;
    }

    public static int[][] createChessBoard() {
        int[][] res = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                res[i][j] = (i + j) % 2 == 0 ? 0 : 1;
//                if ((i + j) % 2 == 1)
//                    res[i][j] = 1;
            }
        }

        return res;
    }

    public static int getNumberOnlyPositiveNumberArraysContinue(int[][] array) {
        int res = 0;

        Metka:
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] <= 0)
                    continue Metka;
            }
            res++;
        }

        return res;
    }

    public static int getNumberOnlyPositiveNumberArrays(int[][] array) {
        int res = 0;

        for (int i = 0; i < array.length; i++) {
            boolean wasNegative = false;

            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] <= 0) {
                    wasNegative = true;
                    break;
                }
            }

            if (!wasNegative)
                res++;
        }

        return res;
    }
}
