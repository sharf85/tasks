package com.telran;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        int[] javaArray = new int[]{1, 3, -8};

        ArrayUtils.selectionSort(javaArray);

        System.out.println(Arrays.toString(javaArray));
    }
}
