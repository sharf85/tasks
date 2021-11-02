package de.telran;

public class Main {

    public static void main(String[] args) {
        int[][] array1 = new int[][]{
                {1, 2, 3, 4, 5},
                {2, 3, 7, 5, 9},
                {2, 5, -1, 4},
                {8, 5, 1, 4}
        };

        int[][] array2 = new int[][]{
                {2, 2, 2},
                {2, 2, 2},
                {-2, 2, 2, 2},
                {2, 2, 2}
        };

        System.out.println(countSubarraysWithPositivesOnly(array1));//3
        System.out.println(sumNumbersFromSubarraysWithoutNegatives(array1));//59

        System.out.println(fibonacciArray(1));
        System.out.println(fibonacciArray(2));
        System.out.println(fibonacciArray(3));
        System.out.println(fibonacciArray(4));
        System.out.println(fibonacciArray(5));
        System.out.println(fibonacciArray(6));
    }

    //Функция принимает двумерный массив и возвращает количество подмассивов (строк),
    //в которых нет отрицательных элементов (continue с меткой). static int function (int [][] arr)
    static int countSubarraysWithPositivesOnly(int[][] array) {
        int res = 0;

        outerFor:
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] <= 0) {
                    continue outerFor;
                }
            }
            res++;
        }

        return res;
    }

    //сложить числа в двумерном массиве только из тех подмассивов, где нету отрицательных элементов.
    static int sumNumbersFromSubarraysWithoutNegatives(int[][] array) {
        int res = 0;

        outerFor:
        for (int i = 0; i < array.length; i++) {
            int localSum = 0;

            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 0) {
                    continue outerFor;
                } else {
                    localSum += array[i][j];
                }
            }

            res += localSum;
        }

        return res;
    }

    //написать ф-ю, которая ищет (возвращает) n-ое число Фибоначчи.
    static long fibonacciArray(int n) {
        if (n == 0)
            return 0;

        long[] fibonaccies = new long[n + 1];

        fibonaccies[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibonaccies[i] = fibonaccies[i - 1] + fibonaccies[i - 2];
        }

        return fibonaccies[n];
    }

    //написать ф-ю, которая ищет (возвращает) n-ое число Фибоначчи.
    static long fibonacci(int n) {
        if (n == 0)
            return n;

        int prev = 0;
        int current = 1;

        for (int i = 1; i < n; i++) {
            int temp = current;
            current = current + prev;
            prev = temp;
        }

        return current;
    }

}
