import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTwoArrayElementsTest {

    ProductTwoArrayElements product = new ProductTwoArrayElements();

    @Test
    public void testIsNumberProduct_10elements_true() {
        int[] array = {1, 3, 4, 5, 8, 10, 11, 12, 13, 15};
        assertTrue(product.isNumberProduct(array, 24));
    }

    @Test
    public void testIsNumberProduct_9elements_false() {
        int[] array = {1, 4, 5, 8, 10, 11, 12, 13, 15};
        assertFalse(product.isNumberProduct(array, 24));
    }
}