package com.telran;

import java.util.Arrays;

public class ArrayExercises {

    public static void main(String[] args) {
        // check
        int[] array1 = {2, 4, 2, 0, 5, 8};
        int[] array2 = {2, 4, 2, 0, 8};

        System.out.println(isOddNumberInArray(array1));//true
        System.out.println(isOddNumberInArray(array2));//false

        System.out.println(sumOddNumbersInArray(array1));//5
        System.out.println(sumOddNumbersInArray(array2));//0

        int[] arrayToReverse = {2, 3, -10, 21};
        int[] reversedArray = reverse(arrayToReverse);
        System.out.println(Arrays.toString(arrayToReverse));
        System.out.println(Arrays.toString(reversedArray));


        System.out.println(Arrays.toString(arrayToReverse));
        multiplyPositiveMembersBy3InPlace(arrayToReverse);
        System.out.println(Arrays.toString(arrayToReverse));
        multiplyPositiveMembersBy3InPlace(arrayToReverse);
        System.out.println(Arrays.toString(arrayToReverse));

        System.out.println(isNumberInArray(10, new int[]{5, -19, 10, 7}));//true
        System.out.println(isNumberInArray(10, new int[]{5, -19, 11, 7}));//false

        System.out.println(sumEvenNumbersNonGreaterThanNInArray(10, new int[]{-11, 15, 8, 5, 20, 4, -6}));//6
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

    // reverse array

    static int[] reverse(int[] array) {
        int length = array.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = array[length - 1 - i];
        }
        return result;
    }

    static int[] multiplyPositiveMembersBy3(int[] array) {
        int length = array.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            if (array[i] > 0) {
                result[i] = array[i] * 3;
            } else {
                result[i] = array[i];
            }
        }
        return result;
    }

    static void multiplyPositiveMembersBy3InPlace(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            if (array[i] > 0) {
                array[i] = array[i] * 3;
            }
        }
    }

    //whether the number is in the array
    static boolean isNumberInArray(int n, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n)
                return true;
        }
        return false;
    }

    static int sumEvenNumbersNonGreaterThanNInArray(int n, int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= n && array[i] % 2 == 0)
                sum += array[i];
        }
        return sum;
    }
}
