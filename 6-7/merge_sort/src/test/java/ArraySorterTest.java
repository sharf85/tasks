import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArraySorterTest {

    private ArraySorter arraySorter;

    @Before
    public void init() {
        arraySorter = new ArraySorter();
    }

    @Test
    public void testMergeSort_2numbersSorted() {
        int[] res = new int[]{4, 5};
        assertArrayEquals(res, arraySorter.mergeSort(res));
    }

    @Test
    public void testMergeSort_2numbers() {
        int[] res = new int[]{5, 4};
        assertArrayEquals(new int[]{4, 5}, arraySorter.mergeSort(res));
    }

    @Test
    public void testMergeSort_5numbers() {
        int[] res = new int[]{5, 4, 10, 19, 3};
        assertArrayEquals(new int[]{3, 4, 5, 10, 19}, arraySorter.mergeSort(res));
    }

    @Test
    public void testMergeSort_6numbers() {
        int[] res = new int[]{5, 4, 9, 1, 0, -1};
        assertArrayEquals(new int[]{-1, 0, 1, 4, 5, 9}, arraySorter.mergeSort(res));
    }
}
