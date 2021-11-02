package de.telran;

public class Main {

    public static void main(String[] args) {
        int[][] array1 = new int[][]{
                {5, -3, 10},
                {15, 3, 10, 7},
                {5, -3, -8},
                {2, 1, 0},
                {-1, -5}
        };
        System.out.println(countSubarraysWithPositivesOnly(array1));//1

        printArray(countSumsSubarraysContainingPositives(array1));

        int[] unsortedArray = new int[]{12, -8, 5, 17, -1, 25};
        selectionSort(unsortedArray);

        printArray(unsortedArray);
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    //В двумерном массиве посчитать количество подмассивов, содержащих ТОЛЬКО положительные элементы. (использовать continue с меткой)
    static int countSubarraysWithPositivesOnly(int[][] array) {
        int res = 0;

        outerFor:
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] <= 0) {
                    continue outerFor;
                }
            }
            res++;
        }

        return res;
    }

    //Есть двумерный массив. Вернуть одномерный массив, содержащий суммы подмассивов первого массива,
    //у которых есть положительные элементы. (см 3 задача предыдущего ДЗ)
    static int[] countSumsSubarraysContainingPositives(int[][] array) {
        int[] res = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            boolean containsPositive = false;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    containsPositive = true;
                }
                sum += array[i][j];
            }

            if (!containsPositive)
                res[i] = 0;
            else
                res[i] = sum;

        }

        return res;
    }

    //Написать функцию, которая находит min элемент из массива.
    static int min(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    //Написать сортировку выбором (Selection Sort)
    static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            // search for the index of the min element of the elements being not on its place
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // swap the min with the i-th element (placing the i-th element onto its place)
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

    }

    //написать ф-ю, которая ищет (возвращает) n-ое число Фибоначчи.
    static long fibonacci(int n) {
        if (n == 0)
            return 0;

        int prev = 0;// 0th element
        int current = 1;// 1st element

        for (int i = 1; i < n; i++) {
            int temp = current;
            current = current + prev;
            prev = temp;
        }

        return current;
    }


    static long fibonacciArray(int n) {
        if (n == 0)
            return 0;

        int[] array = new int[n + 1];
        array[1] = 1;

        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];
    }
}
