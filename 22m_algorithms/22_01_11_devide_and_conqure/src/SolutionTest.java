import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void testMergeSort() {
        int[] array1 = {1, 6, 3, -6, 4, 7, 9, 2, 5, -2};
        int[] array2 = {-6, -2, 1, 2, 3, 4, 5, 6, 7, 9};

        solution.mergeSort(array1);
        assertArrayEquals(array1, array2);
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
            assertEquals(array1[i], array2[i]);
        }
    }

    @Test
    public void positiveTest() {
        int[] actual = {5, 1, 6, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6};
        solution.mergeSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void zeroElementTest() {
        int[] actual = {};
        int[] expected = {};
        solution.mergeSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void negativElementTest() {
        int[] actual = {-3, 5, 23, -1, 0, -34};
        int[] expected = {-34, -3, -1, 0, 5, 23};
        solution.mergeSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindDom_negative() {
        int[] array = {2, 2, 3, 3, 2, 3};
        assertEquals(-1, solution.findDominant(array));
    }

    @Test
    public void testFindDom_positive() {
        int[] array = {2, 2, 2, 3, 2, 3};
        assertEquals(2, solution.findDominant(array));
    }
}
