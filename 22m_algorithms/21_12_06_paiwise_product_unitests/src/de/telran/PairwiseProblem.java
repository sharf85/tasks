package de.telran;

public class PairwiseProblem {
    /**
     * The method must calculate the max pairwise product from the array with only non-negative numbers
     *
     * @param array the array to find the product from. The array must by of length > 1
     * @return max pairwise product
     * @throws IllegalArgumentException if the length of the array is lower than 2
     */
    public long solve(int[] array) {
        if (array.length < 2)
            throw new IllegalArgumentException();

        // find the index of the max element
        int maxNumberIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxNumberIndex])
                maxNumberIndex = i;
        }

        int maxNumber = array[maxNumberIndex];
        array[maxNumberIndex] = array[0];
        array[0] = maxNumber;

        int prevMaxNumberIndex = 1;
        for (int i = 2; i < array.length; i++) {
            if (array[i] > array[prevMaxNumberIndex])
                prevMaxNumberIndex = i;
        }

        return (long) maxNumber * array[prevMaxNumberIndex];
    }

//    public long solve(int[] array) {
//        long result = 0;
//
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                long multiplication = (long) array[i] * array[j];
//                if (multiplication > result)
//                    result = multiplication;
//            }
//        }
//
//        return result;
//    }


}
