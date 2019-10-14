import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


import static org.junit.Assert.assertEquals;

public class GCDTest {

    @Mock
    GCD gcd;

    @Before
    public void init() {
        gcd = new GCD();
    }

    @Test
    public void testCompute_9and12_3() {
        assertEquals(3, gcd.compute(9, 12));
    }

    @Test
    public void testCompute_25and12_1() {
        assertEquals(1, gcd.compute(25, 12));
    }

    @Test
    public void testCompute_36and84_12() {
        assertEquals(12, gcd.compute(36, 84));
    }
}
