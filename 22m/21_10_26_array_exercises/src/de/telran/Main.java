package de.telran;

public class Main {

    //Заполнить массив числами от 0 до его длины минус 1 в обратном порядке. ({5,4,3,2,1,0}) . Написать функцию static void function(int[]array)
    //Написать функцию, которая определяет, есть ли в массиве отрицательные элементы. static boolean function(int[] array)
    //--"-- есть ли в массиве нечетные элементы. static boolean function(int[] array)
    //--"-- есть ли в массиве заданное число. static boolean function(int[] array)
    //вернуть сумму всех четных чисел из массива. static int function(int[] array)
    //(*) развернуть массив. static void function(int[]array) {5, 10, 7, 15} -> {15, 7, 10, 5}
    //заполнить массив элементами, равными 3 * на номер индекса
    //заменить все отрицательные элементы на абсолютное значение (-3 -> 3, -239 -> 239)

    public static void main(String[] args) {
        int[] array = new int[10];

        printArray(array);
        fillArrayReversed(array);
        printArray(array);

        int[] otherArray = new int[]{6, 8, -5, 14};
        System.out.println(containsNegatives(otherArray));//true

        System.out.println(containsNegatives(array));//false

        System.out.println(containsOdds(array));//true
        System.out.println(containsOdds(otherArray));//true

        System.out.println(containsNumber(array, 9));//true
        System.out.println(containsNumber(otherArray, 9));//false

        fillArrayWithTripleIndex(array);
        printArray(array);

        makeNegativesPositive(otherArray);
        printArray(otherArray);

        reverseArray(array);
        printArray(array);
        reverseArray(otherArray);
        printArray(otherArray);
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //Заполнить массив числами от 0 до его длины минус 1 в обратном порядке. ({5,4,3,2,1,0}) . Написать функцию static void function(int[]array)
    static void fillArrayReversed(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - 1 - i;
        }
    }

    //Написать функцию, которая определяет, есть ли в массиве отрицательные элементы. static boolean function(int[] array)
    static boolean containsNegatives(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0)
                return true;
        }
        return false;
    }

    //--"-- есть ли в массиве нечетные элементы. static boolean function(int[] array)
    static boolean containsOdds(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0)
                return true;
        }
        return false;
    }

    //--"-- есть ли в массиве заданное число. static boolean function(int[] array)
    static boolean containsNumber(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number)
                return true;
        }
        return false;
    }

    //заполнить массив элементами, равными 3 * на номер индекса
    static void fillArrayWithTripleIndex(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 3 * i;
        }
    }

    //заменить все отрицательные элементы на абсолютное значение (-3 -> 3, -239 -> 239)
    static void makeNegativesPositive(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0)
                array[i] = -array[i];
        }
    }

    static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            // i <-> length - 1 - i
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}
