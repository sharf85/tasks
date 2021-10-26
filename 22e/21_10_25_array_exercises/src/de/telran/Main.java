package de.telran;

public class Main {
    //    1. Заполнить массив числами от 0 до его длины минус 1 в обратном порядке. ({5,4,3,2,1,0}) .
    //    Написать функцию static void function(int[]array)
    //    2. (*) развернуть массив. static void function(int[]array) {5, 10, 7, 15} -> {15, 7, 10, 5}.
    //    Написать функцию static void function(int[]array)
    //    3. Заполнить массив элементами, равными 3 * на номер индекса. Написать функцию static void function(int[]array)
    //    4. Заменить все отрицательные элементы на абсолютное значение (-3 -> 3, -239 -> 239).
    //    Написать функцию static void function(int[]array)
    //    5. Если номер кредита делится на 13, его никто не выдает. Если номер кредита делится на 3, его выдает Маша.
    //    Если остаток от деления номера кредита равен 1, его выдает Петя. Если 2, то Вася. Вывести в консоль, кто выдал
    //    текущий кредит, а также после всех выданных кредитов вывести их количество. Если известен номер послднего
    //    выданного кредита. static void function(int creditNumber)
    //    6. В двумерном массиве посчитать количество строк с отрицательными элементами (использовать break) .
    //    Написать функцию static int function(int[][]array)
    public static void main(String[] args) {
        int[] array = new int[15];//{0,...,0}

        printArray(array);
        fillArrayReversed(array);
        printArray(array);

        fillArrayTripleIndex(array);
        printArray(array);

        int[] otherArray = new int[]{8, -3, 4, -7, -1, 12};
        swapNegatives(otherArray);
        printArray(otherArray);

        reverseArray(otherArray);
        printArray(otherArray);

        int[][] matrix = {
                {-1, 2, -3, 4, -5, 6, -7},
                {8, -9, 10, -11, 12, -13, 14},//matrix[1]
                {15, 16, 17, 18, 19, 20, 21, 22},
                {-23, 24, -25, 26, -27, 28, -29, 30}
        };
        System.out.println(getNumberOfRowsWithNegatives(matrix));
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //1. Заполнить массив числами от 0 до его длины минус 1 в обратном порядке. ({5,4,3,2,1,0}) .
    //     Написать функцию static void function(int[]array)
    static void fillArrayReversed(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - 1 - i;
        }
    }

    //Заполнить массив элементами, равными 3 * на номер индекса. Написать функцию static void function(int[]array)
    static void fillArrayTripleIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 3 * i;
        }
    }

    //Заменить все отрицательные элементы на абсолютное значение (-3 -> 3, -239 -> 239).
    //Написать функцию static void function(int[]array)
    static void swapNegatives(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = -array[i];
            }
        }
    }

    static int getNumberOfRowsWithNegatives(int[][] array) {
        int res = 0;

        //label
        outerFor:
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 0) {
                    res++;
                    continue outerFor;
                }
            }
        }
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                if (array[i][j] < 0) {
//                    res++;
//                    break;
//                }
//            }
//        }

        return res;
    }

    //развернуть массив. static void function(int[]array) {5, 10, 7, 15} -> {15, 7, 10, 5}.
    //Написать функцию static void function(int[]array)
    static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i];
            array[i] = temp;
        }
    }
}
