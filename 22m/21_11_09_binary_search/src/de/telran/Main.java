package de.telran;

public class Main {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 5, 7, 12, 15}, 7));//2
        System.out.println(binarySearch(new int[]{1, 5, 7, 12, 15}, 1));//0
        System.out.println(binarySearch(new int[]{1, 5, 7, 12, 15}, 15));//4

        System.out.println(binarySearch(new int[]{1, 5, 7, 12, 15}, 6));//-3
        System.out.println(binarySearch(new int[]{1, 5, 7, 12, 15}, 0));//-1
        System.out.println(binarySearch(new int[]{1, 5, 7, 12, 15}, 3));//-2
        System.out.println(binarySearch(new int[]{1, 5, 7, 12, 15}, 10));//-4
        System.out.println(binarySearch(new int[]{1, 5, 7, 12, 15}, 14));//-5
        System.out.println(binarySearch(new int[]{1, 5, 7, 12, 15}, 18));//-6
    }

    //Написать метод, который принимает отсортированный массив и число, и возвращает либо реальный индекс,
    //по которому находится число, либо число, равное индексу, на который можно поставить элемент, не нарушая порядка,
    //плюс 1 и с минусом.
    //Пример 1: func({1, 5, 7, 12, 15}, 7) -> 2
    //Пример 2: func({1, 5, 7, 12, 15}, 6) -> -3
    //Пример 3: func({1, 5, 7, 12, 15}, 0) -> -1
    static int binarySearch(int[] array, int number) {
        int minIndex = 0;
        int maxIndex = array.length - 1;

        while (minIndex <= maxIndex) {
            int midIndex = (maxIndex + minIndex) / 2;

            if (array[midIndex] < number) {
                minIndex = midIndex + 1;
            } else if (array[midIndex] > number) {
                maxIndex = midIndex - 1;
            } else {
                return midIndex;
            }
        }

        return -(maxIndex + 1);
    }
}
