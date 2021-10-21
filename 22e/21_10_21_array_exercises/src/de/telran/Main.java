package de.telran;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{5, 2, -10, 15, 7};
        printArrayReversed(array);
        System.out.println(sumOdds(array));
        System.out.println(sumPositives(array));
        System.out.println(containsNumber(array, 15));
        System.out.println(sumEvensLowerThan(array, 0));

        array = new int[]{15, 8, 4, -6};
        printArrayReversed(array);
        System.out.println(sumOdds(array));
        System.out.println(sumPositives(array));
        System.out.println(containsNumber(array, 14));
        System.out.println(sumEvensLowerThan(array, 6));

        int[] array1 = new int[]{3, -2, 9, 6};
        printArray(array1);
        int[] array2 = new int[]{5, -8, 19, 27, 36};
        printArray(array2);
        array2 = new int[]{5, 2, -10, 15, 7, 100, 200};
        printArray(array2);
        array2 = array1;
        printArray(array2);

        array1[2] = 90;
        printArray(array1);
        printArray(array2);
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //распечатать массив задом наперед (если 1, 5 ,7 , то 7, 5 ,1)
    static void printArrayReversed(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //написать функцию, которая принимает массив int, а возвращает сумму всех нечетных элементов из нее (for & if)
    static int sumOdds(int[] array) {
        int res = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1)
                res += array[i];
        }

        return res;
    }

    //написать функцию, которая принимает массив int, а возвращает сумму всех положительных элементов из него (for & if)
    static int sumPositives(int[] array) {
        int res = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0)
                res += array[i];
        }

        return res;
    }

    //функция определяет, есть ли в массиве заданное число.
    static boolean containsNumber(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number)
                return true;
        }
        return false;
    }

    //функция считает сумму всех четных чисел из массива, не превышающих N. (не превышающий <=)
    //    static int function(int[]array,int number)
    static int sumEvensLowerThan(int[] array, int number) {
        int res = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] <= number)
                res += array[i];
        }

        return res;
    }
}
