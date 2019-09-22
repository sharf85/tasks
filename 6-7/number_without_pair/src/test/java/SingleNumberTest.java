import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleNumberTest {

    private SingleNumber singleNumber;

    @Before
    public void init() {
        singleNumber = new SingleNumber();
    }

    @Test
    public void testReveal_1pair() {
        int[] numbers = new int[]{1, 1, 5};

        assertEquals(5, singleNumber.reveal(numbers));
    }

    @Test
    public void testReveal_2pair() {
        int[] numbers = new int[]{1, 1, 1, 1, 5};

        assertEquals(5, singleNumber.reveal(numbers));
    }

    @Test
    public void testReveal_severalPairsShuffled() {
        int[] numbers = new int[]{1, 5, 1, 1, 7, 5, 8, 1, 7, 9, 8};

        assertEquals(9, singleNumber.reveal(numbers));
    }

    @Test
    public void testReveal_oneNumber() {
        int[] numbers = new int[]{9};

        assertEquals(9, singleNumber.reveal(numbers));
    }

    @Test
    public void testReveal_fiveSameNumbers() {
        int[] numbers = new int[]{3, 5, 3, 3, 1, 2, 1, 3, 4, 2, 3, 5, 4};

        assertEquals(3, singleNumber.reveal(numbers));
    }
}
