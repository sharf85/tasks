package de.telran;

public class Main {

    public static void main(String[] args) {
        int[][] array =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12, 13}
                };

        int[][] array2 = new int[3][4];//
//        {
//            {0, 0, 0, 0},
//            {0, 0, 0, 0},
//            {0, 0, 0, 0}
//        };

        array2[1] = new int[]{1, 2};
//        {
//            {0, 0, 0, 0},
//            {1, 2},
//            {0, 0, 0, 0}
//        };

        array2[2] = null;
//        {
//            {0, 0, 0, 0},
//            {1, 2},
//            null
//        };

        int[][] array3 = new int[3][];
//        {
//            null,
//            null,
//            null
//        };
        System.out.println(array3[0]);


        int[][][] array4 =
                {
                        {
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12, 13}
                        },
                        {
                                {0, 0, 0, 0},
                                {1, 2},
                                null
                        }
                };
    }

    //В двумерном массиве определить, есть ли в нем отрицательные элементы
    static boolean containsNegatives(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 0)
                    return true;
            }
        }
        return false;
    }

}
