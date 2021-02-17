import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testSolve_equalNumbers_noOccurrence() {
        int res = solution.solve(5, 5, 1);
        assertEquals(0, res);
    }

    @Test
    public void testSolve_equalNegativeNumbers_noOccurrence() {
        int res = solution.solve(-5, -5, 1);
        assertEquals(0, res);
    }

    @Test
    public void testSolve_equalNumbers_oneOccurrence() {
        int res = solution.solve(5, 5, 5);
        assertEquals(1, res);
    }

    @Test
    public void testSolve_equalNegativeNumbers_oneOccurrence() {
        int res = solution.solve(-5, -5, 5);
        assertEquals(1, res);
    }

    @Test
    public void testSolve_nonEqualNumbers_oneOccurrence() {
        int res = solution.solve(0, 10, 5);
        assertEquals(1, res);
    }

    @Test
    public void testSolve_nonEqualNumbers_allNumbersContainDigit() {
        int res = solution.solve(110, 120, 1);
        assertEquals(11, res);
    }

    @Test
    public void testSolve_nonEqualNumbers_twoZeros() {
        int res = solution.solve(110, 120, 0);
        assertEquals(2, res);
    }

    @Test
    public void testSolve_from1to1000_() {
        int res = solution.solve(0, 999, 1);
        assertEquals(271, res);
    }

}
