package de.telran;

public class Main {

    public static void main(String[] args) {
        int[][] array1 = new int[][]{
                {5, -3, 10},//12
                {15, 3, 10, 7},//35
                {5, -3, -8},//-6
                {2, 1, 0},//3
                {-1, -5}
        };

        System.out.println(countSumFromSubarraysContainingPositive(array1));//44

        System.out.println(getIndex(new int[]{1, 5, 7, 12, 15}, 7));//2
        System.out.println(getIndex(new int[]{1, 5, 7, 12, 15}, 6));//-3
        System.out.println(getIndex(new int[]{1, 5, 7, 12, 15}, 0));//-1
        System.out.println(getIndex(new int[]{1, 5, 7, 12, 15}, 20));//-6
    }

    // Есть двумерный массив. Посчитать сумму только тех элементов, которые лежат в подмассивах, в которых есть положительные элементы
    static int countSumFromSubarraysContainingPositive(int[][] array) {
        int res = 0;

        for (int i = 0; i < array.length; i++) {
            int subarraySum = 0;
            boolean isPositive = false;

            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    isPositive = true;
                }

                subarraySum += array[i][j];
            }

            if (isPositive) {
                res += subarraySum;
            }
        }

        return res;
    }

    //Написать метод, который принимает отсортированный массив и число, и возвращает либо реальный индекс,
    //по которому находится число, либо число, равное индексу, на который можно поставить элемент, не нарушая порядка,
    //плюс 1 и с минусом.
    //Пример 1: func({1, 5, 7, 12, 15}, 7) -> 2
    //Пример 2: func({1, 5, 7, 12, 15}, 6) -> -3
    //Пример 3: func({1, 5, 7, 12, 15}, 0) -> -1
    static int getIndex(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (number == array[i])
                return i;

            if (number < array[i])
                return -(i + 1);
        }

        return -(array.length + 1);
    }
}
