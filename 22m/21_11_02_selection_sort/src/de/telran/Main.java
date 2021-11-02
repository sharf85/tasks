package de.telran;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {12, 5, 7, -3, 2, -8};

        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void selectionSort(int[] array) {
        int stepNumber = array.length - 1;

        for (int i = 0; i < stepNumber; i++) {

            int minEltIndex = i;

            //searching for the min from the rest of elements
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minEltIndex]) {
                    minEltIndex = j;
                }
            }

            //swap the min element with the i-th element, so that the min element stands on its place
            int temp = array[i];
            array[i] = array[minEltIndex];
            array[minEltIndex] = temp;
        }
    }
}
