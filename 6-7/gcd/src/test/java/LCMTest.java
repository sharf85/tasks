import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import static org.junit.Assert.assertEquals;

public class LCMTest {

    //    @Mock
    private GCD gcdMock;

    private LCM lcm;


    @Before
    public void init() {
        gcdMock = mock(GCD.class);
        lcm = new LCM(gcdMock);
    }

    @Test
    public void testCompute_9and12_36() {
        when(gcdMock.compute(9, 12)).thenReturn(3L);
        assertEquals(36, lcm.compute(9, 12));
    }

    @Test
    public void testCompute_25and12_300() {
        when(gcdMock.compute(25, 12)).thenReturn(1L);
        assertEquals(300, lcm.compute(25, 12));
    }

    @Test
    public void testCompute_36and84_252() {
        when(gcdMock.compute(36, 84)).thenReturn(12L);
        assertEquals(252, lcm.compute(36, 84));
    }


}
