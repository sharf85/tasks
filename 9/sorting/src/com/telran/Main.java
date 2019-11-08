package com.telran;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = {8, 2, 5, 0, -10, 4};
        System.out.println(array);
        selectionSort(array);
        System.out.println(Arrays.toString(array));
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
}
