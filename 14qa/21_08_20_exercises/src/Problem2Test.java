import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    Problem2 problem2 = new Problem2();

    @Test
    public void testSolve_emptyString_emptyString() {
        String a = "";

        assertEquals(a, problem2.solve(a));
    }

    @Test
    public void testSolve_String10_modString() {
        String res = problem2.solve("ab");

        assertEquals(2, res.length());
    }

    @Test
    public void testSolve_String9_modString() {
        String res = problem2.solve("Aa");

        assertEquals("aA", res);
    }

    @Test
    public void testSolve_String8_modString() {
        String res = problem2.solve("AB");

        assertEquals("ab", res);
    }

    @Test
    public void testSolve_String7_modString() {
        String res = problem2.solve("ab");

        assertEquals("AB", res);
    }

    @Test
    public void testSolve_String6_modString() {
        String res = problem2.solve("1");

        assertEquals("1", res);
    }

    @Test
    public void testSolve_String_modString() {
        String res = problem2.solve("!");

        assertEquals("!", res);
    }

    @Test
    public void testSolve_baxAndSomething() {
        String res = problem2.solve("!SomeThing");

        assertEquals("!sOMEtHING", res);
    }

    @Test
    public void testSolve_WithSpaceAtBeginString_modString() {
        String res = problem2.solve(" ab");

        assertEquals(" AB", res);
    }

    @Test
    public void testSolve_String5_modString() {
        String res = problem2.solve("ab ");

        assertEquals("AB ", res);
    }

    @Test
    public void testSolve_String4_modString() {
        String res = problem2.solve(" ab ");

        assertEquals(" AB ", res);
    }

    @Test
    public void testSolve_String3_modString() {
        String res = problem2.solve("a b");

        assertEquals("A B", res);
    }

    @Test
    public void testSolve_String1_modString() {
        String res = problem2.solve("abc");

        assertEquals("ABC", res);
    }

    @Test
    public void testSolve_String2_modString() {
        String res = problem2.solve("AaB!S§$%rtFgr1245Qa.");

        assertEquals("aAb!s§$%RTfGR1245qA.", res);
    }

}
