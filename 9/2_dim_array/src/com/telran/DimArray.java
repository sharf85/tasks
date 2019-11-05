package com.telran;

import java.util.Arrays;

public class DimArray {

    public static void main(String[] args) {
        int[][] array = fillArray();

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    // returns a double array with numbers from 0-99
    static int[][] fillArray() {
        int[][] result = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                result[i][j] = i * 10 + j;
            }
        }
        return result;
    }
}
