package de.telran;

public class Main {

    public static void main(String[] args) {
        //Создать двумерный массив 10x10 и заполнить его числами от 99 до 0 (в методе main)
        int[][] array10x10 = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                array10x10[i][j] = 99 - 10 * i - j;
            }
        }

        print2DimArray(array10x10);

        int[] array = new int[]{1, 2, -3, 4, -5};
        multiplyPositivesBy3(array);
        printArray(array);

        makeOddIndiciesZero(array);
        printArray(array);

        int[][] array2Dim = new int[][]{
                {1, 2, 3, -4, -5},
                {6, 7, 8, 9, 10},
                {6, 7, 8, 56, 10},
                {6, 12, 8, 9, 10, -15}
        };

        int[][] array2DimPositives = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {6, 7, 8, 56, 10},
                {6, 12, 8, 9, 10, 15}
        };

        System.out.println(containsNegatives(array2Dim));
        System.out.println(containsNegatives(array2DimPositives));

        System.out.println(getNumberSubarraysWithNegatives(array2Dim));//2
        System.out.println(getNumberSubarraysWithNegatives(array2DimPositives));//0
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    static void print2DimArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            printArray(array[i]);
        }
    }

    //Функция принимает одномерный массив и умножает на 3 все его положительные элементы. static void function(int[] arr)
    static void multiplyPositivesBy3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                array[i] *= 3;
            }
        }
    }

    //Функция принимает одномерный массив и меняет все элементы с нечетными индексами на 0.
    static void makeOddIndiciesZero(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                array[i] = 0;
            }
        }
    }

    //Функция принимает двумерный массив и возвращает да или нет, есть ли отрицательные элементы в нем.
    //static boolean function (int[][] arr)
    static boolean containsNegatives(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 0) {
                    return true;
                }
            }
        }

        return false;
    }

    //Функция принимает двумерный массив и возвращает количество подмассивов (строк), в которых есть отрицательные
    //элементы (использовать break). static int function (int [][] arr)
    static int getNumberSubarraysWithNegatives(int[][] array) {
        int res = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 0) {
                    res++;
                    break;
                }
            }
        }

        return res;
    }

}
