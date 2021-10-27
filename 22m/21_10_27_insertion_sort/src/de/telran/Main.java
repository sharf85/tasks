package de.telran;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] array = new int[]{12, -6, 7, 4, 10};//

        System.out.println(findMin(array));// -6

        insertionSort(array);
        printArray(array);// {-6, 4, 7, 10, 12}
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];

            int j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    static int findMin(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        return min;
    }
}
