import java.util.Arrays;

public class ArraySorter {

    public int[] mergeSort(int[] array) {
        int length = array.length;
        if (length == 1)
            return array;

        int[] arrayLeft = Arrays.copyOfRange(array, 0, length / 2);
        int[] arrayRight = Arrays.copyOfRange(array, length / 2, length);

        return merge(mergeSort(arrayLeft), mergeSort(arrayRight));
    }

    private int[] merge(int[] arrayLeft, int[] arrayRight) {
        int lengthLeft = arrayLeft.length;
        int lengthRight = arrayRight.length;

        int length = lengthLeft + lengthRight;

        int[] res = new int[length];

        int i = 0;
        int j = 0;

        while (i + j < length) {
            if (i == lengthLeft) {
                res[i + j] = arrayRight[j];
                j++;
            } else if (j == lengthRight) {
                res[i + j] = arrayLeft[i];
                i++;
            } else {
                if (arrayLeft[i] < arrayRight[j]) {
                    res[i + j] = arrayLeft[i];
                    i++;
                } else {
                    res[i + j] = arrayRight[j];
                    j++;
                }
            }
        }
        return res;
    }

}
