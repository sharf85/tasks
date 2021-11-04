package de.telran;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[5];

        array[2] = 10;//{0,0,10,0,0}

        int[] array2 = append(array, 7);//{0,0,10,0,0,7}

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));

        array2 = insert(array2, 3, 11);//{0,0,10,11,0,0,7}
        System.out.println(Arrays.toString(array2));

        array2 = delete(array2, 4);
        System.out.println(Arrays.toString(array2));
        array2 = delete(array2, 4);
        System.out.println(Arrays.toString(array2));

        System.out.println(getIndex(new int[]{1, 5, 7, 12, 15}, 7));//2
        System.out.println(getIndex(new int[]{1, 5, 7, 12, 15}, 6));//-3
        System.out.println(getIndex(new int[]{1, 5, 7, 12, 15}, 0));//-1
        System.out.println(getIndex(new int[]{1, 5, 7, 12, 15}, 20));//-6
    }

    /**
     * creates a new array in memory, which is a copy of the old array, and then returns a reference to it
     *
     * @param array to copy
     * @return a copy
     */
    static int[] copy(int[] array) {
        int[] res = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            res[i] = array[i];
        }

        return res;
    }

    static int[] append(int[] array, int elt) {
        int[] res = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            res[i] = array[i];
        }

        res[res.length - 1] = elt;
        return res;
    }

    static int[] insert(int[] array, int index, int elt) {
        int[] res = new int[array.length + 1];

        for (int i = 0; i < index; i++) {
            res[i] = array[i];
        }

        res[index] = elt;

        for (int i = index; i < array.length; i++) {
            res[i + 1] = array[i];
        }

        return res;
    }

    static int[] delete(int[] array, int index) {
        int[] res = new int[array.length - 1];

        for (int i = 0; i < index; i++) {
            res[i] = array[i];
        }

//        for (int i = index + 1; i < array.length; i++) {
//            res[i - 1] = array[i];
//        }
        for (int i = index; i < res.length; i++) {
            res[i] = array[i + 1];
        }

        return res;
    }

    //Написать метод, который принимает отсортированный массив и число, и возвращает либо реальный индекс,
    //по которому находится число, либо число, равное индексу, на который можно поставить элемент,
    //не нарушая порядка, плюс 1 и с минусом.
    //Пример 1: func({1, 5, 7, 12, 15}, 7) -> 2
    //Пример 2: func({1, 5, 7, 12, 15}, 6) -> -3
    //Пример 3: func({1, 5, 7, 12, 15}, 0) -> -1
    //Пример 3: func({1, 5, 7, 12, 15}, 20) -> -6
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
