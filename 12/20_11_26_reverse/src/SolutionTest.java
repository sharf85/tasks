import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testReverse_emptyString_returnsEmptyString() {
        assertEquals("", solution.reverse(""));
    }

    @Test
    public void testReverse2() {
        assertEquals("olleh", solution.reverse("hello"));
    }


    @Test
    public void testReverse3() {
        assertEquals("@ oL2leH", solution.reverse("Hel2Lo @"));
    }

}
