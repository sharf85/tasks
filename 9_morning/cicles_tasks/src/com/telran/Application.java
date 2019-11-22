package com.telran;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        printRangeDown(100, 10, 10);

        printRangeDown(50, 10, 5);

        int sumA = sumArithmeticProgressionUp(1, 87, 1);
        System.out.println(sumA);

        int sumB = sumArithmeticProgressionUp(5, 86, 3);
        System.out.println(sumB);

        int[] array1 = new int[]{1, 2, 3};
        int[] array2 = array1;

        array1[0] = -1;
        System.out.println(array2[0]);//-1

        System.out.println(Arrays.toString(array1));
        reverse(array1);
        System.out.println(Arrays.toString(array1));
    }

    public static void printRangeDown(int first, int last, int step) {
        int number = first;
        while (number >= last) {
            System.out.print(number + " ");
            number -= step;
        }
        System.out.println();
    }

    public static int sumArithmeticProgressionUp(int first, int last, int step) {
        int sum = 0;
        int number = first;
        while (number <= last) {
            sum += number;
            number += step;
        }
        return sum;
    }

    public static void reverse(int[] array) {
        int size = array.length;
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
    }
}
