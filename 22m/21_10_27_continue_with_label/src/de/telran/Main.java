package de.telran;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    //Функция принимает двумерный массив и возвращает количество подмассивов (строк), в которых есть отрицательные
    //элементы (использовать break). static int function (int [][] arr)
    static int getNumberSubarraysWithNegatives(int[][] array) {
        int res = 0;

        outerFor:
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 0) {
                    res++;
                    continue outerFor;
                }
            }
        }

        return res;
    }

    //Функция принимает двумерный массив и возвращает да или нет, есть ли отрицательные элементы в нем.
    //static boolean function (int[][] arr)
    static boolean containsNegatives(int[][] array) {

        boolean res = false;

        outerFor:
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 0) {
                    res = true;
                    break outerFor;
                }
            }
        }

        return res;
    }
}
