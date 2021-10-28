package de.telran;

public class Main {

    public static void main(String[] args) {
        int[] arrayToSort = {14, -7, 3, 8, 11, 0};
        insertionSort(arrayToSort);
        printArray(arrayToSort);
    }

    static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;

            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
