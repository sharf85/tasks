package de.telran;

public class Main {

    public static void main(String[] args) {

        int[] array = {1, 5, 7, 12, 15};
        System.out.println(binarySearch(array, 7));//2
        System.out.println(binarySearch(array, 0));//-1
        System.out.println(binarySearch(array, 15));//4
        System.out.println(binarySearch(array, 17));//-6
        System.out.println(binarySearch(array, 13));//-5
        System.out.println(binarySearch(array, 2));//-2
        System.out.println(binarySearch(array, 6));//-3
        System.out.println(binarySearch(array, 10));//-4

        int[] sortedArray = {0, 5, 14, 28, 32, 52, 58, 71, 82, 84, 92, 95, 100, 114, 152, 282, 258, 271, 332, 364, 396};
        System.out.println(binarySearch(sortedArray, 52));
        System.out.println(binarySearch(sortedArray, 332));
        System.out.println(binarySearch(sortedArray, 425));
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

        int middleIndex = 0;

        while (minIndex <= maxIndex) {
            middleIndex = (maxIndex + minIndex) / 2;

            if (array[middleIndex] < number)
                minIndex = middleIndex + 1;
            else if (array[middleIndex] > number)
                maxIndex = middleIndex - 1;
            else
                return middleIndex;
        }

        return -(minIndex + 1);
    }
}
