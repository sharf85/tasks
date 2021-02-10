import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testFindOne_ten_5() {
        int[] arr10 = {1, 10, 3, 4, 6, 7, 8, 9, 2};
        int actual = solution.solve(arr10);
        int expected = 5;
        assertEquals(expected, actual);

    }

    @Test
    public void testFindOne_ten_1() {
        int[] arr10 = {10, 3, 4, 6, 7, 8, 5, 9, 2};
        int actual = solution.solve(arr10);
        int expected = 1;
        assertEquals(expected, actual);

    }

    @Test
    public void testFindOne_ten_10() {
        int[] arr10 = {1, 5, 3, 4, 6, 7, 8, 9, 2};
        int actual = solution.solve(arr10);
        int expected = 10;
        assertEquals(expected, actual);

    }
}
