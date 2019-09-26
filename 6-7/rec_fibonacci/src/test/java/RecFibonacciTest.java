import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class RecFibonacciTest {

    RecFibonacci recFibonacci;

    @Before
    public void init() {
        recFibonacci = new RecFibonacci();
    }

    @Test
    public void testCompute_zero_zero() {
        assertEquals(BigInteger.valueOf(0), recFibonacci.compute(0));
    }

    @Test
    public void testCompute_one_one() {
        assertEquals(BigInteger.valueOf(1), recFibonacci.compute(1));
    }

    @Test
    public void testCompute_10_55() {
        assertEquals(BigInteger.valueOf(55), recFibonacci.compute(10));
    }

    @Test
    public void testCompute_100_performed() {
        BigInteger res = recFibonacci.compute(2000);
        assertTrue(true);
    }
}
