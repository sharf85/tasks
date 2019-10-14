import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrimariesTest {

    private Primaries primaries;

    @Before
    public void init() {
        primaries = new Primaries();
    }

    @Test
    public void testGetFirstUpToN_number10() {
        List expected = Arrays.asList(2, 3, 5, 7);
        assertEquals(expected, primaries.getFirstUpToN(10));
    }

    @Test
    public void testGetFirstUpToN_number1() {
        assertEquals(new ArrayList<>(), primaries.getFirstUpToN(1));
    }

    @Test
    public void testGetFirstUpToN_number2() {
        List expected = Collections.singletonList(2);
        assertEquals(expected, primaries.getFirstUpToN(2));
    }

    @Test
    public void testGetFirstUpToN_number13() {
        List expected = Arrays.asList(2, 3, 5, 7, 11, 13);
        assertEquals(expected, primaries.getFirstUpToN(13));
    }

}
