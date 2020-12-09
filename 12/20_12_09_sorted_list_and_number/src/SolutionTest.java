import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testSolution1() {
        List<Integer> list = Arrays.asList(2, 5);

        assertTrue(solution.solve(list, 10));
    }

    @Test
    public void testSolution2() {
        List<Integer> list = Arrays.asList(5, 10);

        assertFalse(solution.solve(list, 3));
    }

    @Test
    public void testSolution3() {
        List<Integer> list = Arrays.asList(5, 15);

        assertFalse(solution.solve(list, 10));
    }

    @Test
    public void testSolution4() {
        List<Integer> list = Arrays.asList(5, 15);

        assertFalse(solution.solve(list, 15));
        assertFalse(solution.solve(list, 5));
    }

    @Test
    public void testSolution5() {
        List<Integer> list = Arrays.asList(2, 5, 10, 11, 11, 20, 23);

        assertTrue(solution.solve(list, 55));
        assertTrue(solution.solve(list, 22));
        assertTrue(solution.solve(list, 40));
        assertTrue(solution.solve(list, 46));

        assertTrue(solution.solve(list, 253));
        assertTrue(solution.solve(list, 460));
        assertTrue(solution.solve(list, 121));

        assertFalse(solution.solve(list, 400));
        assertFalse(solution.solve(list, 80));
    }
}
