package com.telran;

public class ArrayExercises {

    public static void main(String[] args) {
        // check
        int[] array1 = {2, 4, 2, 0, 5, 8};
        int[] array2 = {2, 4, 2, 0, 8};

        System.out.println(isOddNumberInArray(array1));//true
        System.out.println(isOddNumberInArray(array2));//false

        System.out.println(sumOddNumbersInArray(array1));//5
        System.out.println(sumOddNumbersInArray(array2));//0

    }

    //    the function accepts int array and returns whether there is an odd element in it
    static boolean isOddNumberInArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1)
                return true;
        }
// if we passed through all the array, it means that no odd numbers met
        return false;
    }

    //    the function accepts int array and returns the sum of the odd elements
    static int sumOddNumbersInArray(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1)
                sum += array[i];
        }

        return sum;
    }
}
