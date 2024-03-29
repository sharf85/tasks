package de.telran;

public class PairwiseProduct {

    /**
     * The method must return the max pairwise product from the array
     *
     * @param array with non-negative numbers
     * @return
     */
    // {12, 1, 8, 10, 3} -> 120
//    public long findMaxPairwiseProduct(int[] array) {
//        long max = 0;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                long mul = (long) array[i] * array[j];
//                if (mul > max)
//                    max = mul;
//            }
//        }
//        return max;
//    }
    public long findMaxPairwiseProduct(int[] array) {
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[maxIndex] < array[i])
                maxIndex = i;
        }

        int max = array[maxIndex];
        array[maxIndex] = array[0];
        array[0] = max;

        int prevMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (prevMax < array[i])
                prevMax = array[i];
        }

        return (long) max * prevMax;
    }

}
