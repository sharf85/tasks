package de.telran;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 9};

        int[] newArray = append(array, 10);
        array = append(array, 10);
        array = append(array, 15);
        array = append(array, 15);
        array = append(array, 1);
        System.out.println(Arrays.toString(newArray));
        System.out.println(Arrays.toString(array));

        array = insert(array, 2, 100);
        System.out.println(Arrays.toString(array));

    }

    /**
     * The method creates an array, which is a copy of the old one, but with the additional element "number" in the end,
     * and returns a reference to it
     *
     * @param array  to append
     * @param number to append to the end of the array
     * @return a reference to the new array being a copy of the old one
     */
    static int[] append(int[] array, int number) {
        int[] res = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            res[i] = array[i];
        }

        res[res.length - 1] = number;
        return res;
    }

    static int[] insert(int[] array, int index, int number) {
        int[] res = new int[array.length + 1];

        for (int i = 0; i < index; i++) {
            res[i] = array[i];
        }

        res[index] = number;

        for (int i = index; i < array.length; i++) {
            res[i + 1] = array[i];
        }

        return res;
    }
}
