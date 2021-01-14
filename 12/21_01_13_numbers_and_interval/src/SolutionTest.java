import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void maxCoveredPoint_cut2_2() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int cut = 2;
        int actual = solution.solve(numbers, cut);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void maxCoveredPoint_cut1_1() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int cut = 1;
        int actual = solution.solve(numbers, cut);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void maxCoveredPoint_cut8_1() {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 31, 40, 55, 58, 64);
        int cut = 9;
        int actual = solution.solve(numbers, cut);
        int expected = 3;
        assertEquals(expected, actual);
    }
}
