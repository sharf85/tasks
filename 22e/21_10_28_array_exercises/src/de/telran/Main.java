package de.telran;

public class Main {

    public static void main(String[] args) {
        int[] fibonaccies = getArrayWithFibonaccies(10);
        printArray(fibonaccies);

//        Создать двумерный массив 10x10 и заполнить его числами от 0 до 99 (в методе main)
        int[][] array10x10 = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                array10x10[i][j] = i * 10 + j;
            }
        }

        setOddIndiciesTo0(fibonaccies);
        printArray(fibonaccies);
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    /**
     * Returns an array with the Fibonacci numbers from 0 up to n inclusive
     *
     * @param n > 0 otherwise the behavior is unpredictable
     * @return
     */
    static int[] getArrayWithFibonaccies(int n) {
        if (n == 0)
            return new int[1];//{0}

        int[] res = new int[n + 1];
//        res[0] = 0; no need in this line
        res[1] = 1;

        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }

        return res;
    }

    static int sum(int[] array) {
        int res = 0;

        for (int i = 0; i < array.length; i++) {
            res += array[i];
        }

        return res;
    }

    //Есть двумерный массив. Вернуть одномерный массив, содержащий суммы подмассивов первого массива.
    //static int[] getFibonaccies(int[][] array)
    static int[] getSubarraysSums(int[][] array) {
        int[] res = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            res[i] += sum(array[i]);
        }

        return res;
    }

    //Есть двумерный массив. Посчитать количество подмассивов, содержащих нечетные числа.
    static int countSubmassivesWithOdds(int[][] array) {
        int res = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % 2 != 0) {
                    res++;
                    break;
                }
            }
        }

        return res;
    }

    //Функция принимает одномерный массив и умножает на 3 все его положительные элементы. static void function(int[] arr)
    static void multiplyPositivesBy3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0)
                array[i] *= 3;//array[i] = array[i] * 3;
        }
    }

    //Функция принимает одномерный массив и меняет все элементы с нечетными индексами на 0.
    static void setOddIndiciesTo0(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0)
                array[i] = 0;
        }
    }
}
