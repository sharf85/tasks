import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    Problem3 gcdSolver = new Problem3();

    @Test
    public void test_gcdSolver1_1_1() {
        assertEquals(1, gcdSolver.gcd(1, 1));
    }

    @Test
    public void testGcd_gcdSolver15_20_5() {
        assertEquals(5, gcdSolver.gcd(15, 20));
    }

    @Test
    public void testGcd_gcdSolver20_15_5() {
        assertEquals(5, gcdSolver.gcd(20, 15));
    }


    @Test
    public void test_gcdSolver42_56_14() {
        assertEquals(14, gcdSolver.gcd(42, 56));
    }


    @Test
    public void test_gcdSolver1071_462_21() {
        assertEquals(21, gcdSolver.gcd(1071, 462));
    }

    @Test
    public void test_gcdSolver462_1071_21() {
        assertEquals(21, gcdSolver.gcd(462, 1071));
    }
}
