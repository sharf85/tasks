import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProblemsTest {

    Problems problems = new Problems();

    @Test
    public void testGcd_ones_one() {
        assertEquals(1, problems.gcd(1, 1));
    }

    @Test
    public void testGcd_oneAndNumber_one() {
        assertEquals(1, problems.gcd(10, 1));
    }

    @Test
    public void testGcd_primaryNumbers_one() {
        assertEquals(1, problems.gcd(7, 37));
        assertEquals(1, problems.gcd(37, 7));
    }

    @Test
    public void testGcd_245And350_one() {
        assertEquals(35, problems.gcd(245, 350));
        assertEquals(35, problems.gcd(350, 245));
    }

    @Test
    public void testLcm_ones_one() {
        assertEquals(1, problems.lcm(1, 1));
    }

    @Test
    public void testLcm_oneAndNumber_one() {
        assertEquals(10, problems.lcm(10, 1));
    }

    @Test
    public void testLcm_primaryNumbers_one() {
        assertEquals(259, problems.lcm(7, 37));
        assertEquals(259, problems.lcm(37, 7));
    }

    @Test
    public void testLcm_245And350_one() {
        assertEquals(2450, problems.lcm(245, 350));
        assertEquals(2450, problems.lcm(350, 245));
    }

    @Test
    void both_numbers_one() {
        assertEquals(1, problems.fibonacciModuloM(1, 1));
    }

    @Test
    void first_numbers_is_0() {
        assertEquals(0, problems.fibonacciModuloM(0, 1));
    }

    @Test
    void devider_is_0() {
        assertEquals(2, problems.fibonacciModuloM(5, 3));
        assertEquals(1, problems.fibonacciModuloM(5, 2));
    }

}
