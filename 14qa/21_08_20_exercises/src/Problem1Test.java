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

}
