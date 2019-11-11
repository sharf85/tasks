package com.telran;

public class BinarySearcher {

    public static void main(String[] args) {
        int[] array = {1, 3, 3, 3, 4, 7, 8, 15, 18, 23, 23, 25};

        int index = binarySearch(array, 0);
        System.out.println(index);
        // write your code here
    }

    private static int binarySearch(int[] array, int N) {
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

}