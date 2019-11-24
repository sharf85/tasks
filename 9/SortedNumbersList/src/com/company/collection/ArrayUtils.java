package com.company.collection;

public class ArrayUtils {


    static int binarySearch(int[] array, int N) {
        int minId = 0;
        int maxId = array.length - 1;

        while (maxId >= minId) {
            int middleId = (maxId + minId) / 2;

            if (array[middleId] == N)
                return middleId;
            else if (array[middleId] > N) {
                maxId = middleId - 1;
            } else {
                minId = middleId + 1;
            }
        }

        return -minId - 1;
    }

    static void selectionSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int min = array[i];
            int minId = i;

            for (int j = i; j < length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    minId = j;
                }
            }

            int temp = array[minId];
            array[minId] = array[i];
            array[i] = temp;
        }
    }


    static int[] copyArray(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    static int[] append(int[] array, int a) {
        int[] result = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        result[array.length] = a;
        return result;
    }

    public static int[] set(int[] array, int a, int id) {
        int[] result = new int[array.length + 1];
        for (int i = 0; i < id; i++) {
            result[i] = array[i];
        }

        result[id] = a;

        for (int i = id + 1; i < result.length; i++) {
            result[i] = array[i - 1];
        }
        return result;
    }

    static int[] union(int[] array1, int[] array2) {
        int arrayLenght = array1.length + array2.length;
        int[] newArray = new int[arrayLenght];
        for (int i = 0; i < array1.length; i++) {
            newArray[i] = array1[i];
        }
        for (int i = array1.length, j = 0; i < arrayLenght; i++) {
            newArray[i] = array2[j++];
        }
        return newArray;
    }
}