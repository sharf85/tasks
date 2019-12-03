package com.telran;

public class ArrayUtils {

    public static int[] copyArray(int[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static int[] append(int[] array, int number) {
        int[] result = insert(array, array.length, number);

        return result;
    }

    public static int[] insert(int[] array, int index, int number) {
        int[] result = new int[array.length + 1];

        for (int i = 0; i < index; i++) {
            result[i] = array[i];
        }

        result[index] = number;

        for (int i = index + 1; i < result.length; i++) {
            result[i] = array[i - 1];
        }

        return result;
    }

    public static int binarySearch(int[] array, int number) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] < number) {
                left = middle + 1;
            } else if (array[middle] > number) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -(left + 1);
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {

            int minId = i;

            for (int j = i; j < array.length; j++) {
                if (array[minId] > array[j]) {
                    minId = j;
                }
            }

            int temp = array[i];
            array[i] = array[minId];
            array[minId] = temp;

        }
    }
}
