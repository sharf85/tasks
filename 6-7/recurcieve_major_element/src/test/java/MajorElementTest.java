import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MajorElementTest {

    MajorElement majorElement;

    @Before
    public void init() {
        majorElement = new MajorElement();
    }

    @Test
    public void testIsMajorElement_5elements_true() {
        int[] array = {-2, 1, -1, -2, -2};
        assertTrue(majorElement.isMajorElement(array));
    }

    @Test
    public void testIsMajorElement_5elements_false() {
        int[] array = {-2, 1, -1, -2, -1};
        assertFalse(majorElement.isMajorElement(array));
    }

    @Test
    public void testIsMajorElement_10elements_false() {
        int[] array = {-2, 1, -1, -2, -2, 5, 6, -2, 1, -2};
        assertFalse(majorElement.isMajorElement(array));
    }

    @Test
    public void testIsMajorElement_10elements_true() {
        int[] array = {-2, 1, -1, -2, -2, -2, 6, -2, 1, -2};
        assertFalse(majorElement.isMajorElement(array));
    }
}