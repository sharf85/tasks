package com.telran;

import java.util.Arrays;

public class ArrayModifications {

    public static void main(String[] args) {

        int[] array = {1, 3, 3, 3, 4, 7, 8, 15, 18, 23, 23, 25};

        int[] modified = set(array, 2, 1);
        System.out.println(Arrays.toString(modified));
    }

    public static int[] copyArray(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static int[] append(int[] array, int a) {
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
}
