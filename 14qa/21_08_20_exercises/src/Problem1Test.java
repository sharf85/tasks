import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    Problem1 problem1;

    @BeforeEach
    public void init() {
        problem1 = new Problem1();
    }

    @Test
    public void testSolve_emptyString_emptyString() {
        String res = problem1.solve("");

        assertEquals("", res);
    }

    @Test
    public void testSolve_oneSymbol_sameString() {
        String res = problem1.solve("a");

        assertEquals("a", res);
    }

    @Test
    public void testSolve_oneString_oneString() {
        String a = "a";

        assertEquals(a, problem1.solve(a));
    }

    @Test
    public void testSolve_oneStringUpper_oneString() {
        String a = "A";

        assertEquals(a, problem1.solve(a));
    }

    @Test
    public void testSolve_String_lengthOfString() {
        String res = problem1.solve("ab");

        assertEquals(2, res.length());
    }

    @Test
    public void testSolve_twoStringUpperAndLower_oneString() {
        String res = problem1.solve("Aa");

        assertEquals("aA", res);
    }

    @Test
    public void testSolve_twoStringUpper_oneString() {
        String res = problem1.solve("AB");

        assertEquals("BA", res);
    }

    @Test
    public void testSolve_String_reversedString() {
        String res = problem1.solve("ab");

        assertEquals("ba", res);
    }

    @Test
    public void testSolve_String_reverseWithSpaceAtBeginString() {
        String res = problem1.solve(" ab");

        assertEquals("ba ", res);
    }

    @Test
    public void testSolve_String_reverseWithSpaceAtEndString() {
        String res = problem1.solve("ab ");

        assertEquals(" ba", res);
    }

    @Test
    public void testSolve_String_reverseWithSpaceAtBeginAndEndString() {
        String res = problem1.solve(" ab ");

        assertEquals(" ba ", res);
    }

    @Test
    public void testSolve_String_reverseWithSpaceAtMiddleString() {
        String res = problem1.solve("a b");

        assertEquals("b a", res);
    }

    @Test
    public void testSolve_StringWithThreeChar_reverseString() {
        String res = problem1.solve("abc");

        assertEquals("cba", res);
    }

    @Test
    public void testMethod_String2_modString() {
        String res = problem1.solve("AaB!S$%rtFgr1245Qa.");

        assertEquals(".aQ5421rgFtr%$S!BaA", res);
    }
}
