package de.telran;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[5];

        array[2] = 10;
        int fromArray = array[2];
        int length = array.length;
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
}
