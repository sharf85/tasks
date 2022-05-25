import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testTransformToCamelCase_3keysWithoutEmbedding() {
        Map<String, Object> json = Map.of(
                "make", "Opel",
                "model", "Astra",
                "year_of_assembling", 2022);

        Map<String, Object> expected = Map.of(
                "make", "Opel",
                "model", "Astra",
                "yearOfAssembling", 2022);

        assertEquals(expected, solution.transformToCamelCase(json));
    }

    @Test
    public void testTransformToCamelCase_4keysWithMapEmbedding() {
        Map<String, Object> address = Map.of(
                "address", "Opelstr. 239",
                "city", "Opeltown",
                "zip", 55555,
                "telephone_number", "+49 30 1234567"
        );
        Map<String, Object> json = Map.of(
                "make", "Opel",
                "model", "Astra",
                "year_of_assembling", 2022,
                "shipping_address", address);


        //expected
        Map<String, Object> expectedAddress = Map.of(
                "address", "Opelstr. 239",
                "city", "Opeltown",
                "zip", 55555,
                "telephoneNumber", "+49 30 1234567"
        );
        Map<String, Object> expected = Map.of(
                "make", "Opel",
                "model", "Astra",
                "yearOfAssembling", 2022,
                "shippingAddress", expectedAddress);

        assertEquals(expected, solution.transformToCamelCase(json));
    }

    @Test
    public void testTransformToCamelCase_4keysWithMapAndListEmbedding() {
        Map<String, Object> address1 = Map.of(
                "address", "Opelstr. 239",
                "city", "Opeltown",
                "zip", 55555,
                "telephone_numbers", List.of("+49 30 1234567", "+49 30 7654321")
        );
        Map<String, Object> address2 = Map.of(
                "address", "VWstr. 239",
                "city", "VWtown",
                "zip", 33333,
                "telephone_numbers", List.of("+49 30 1111111", "+49 30 2222222")
        );
        Map<String, Object> json = Map.of(
                "make", "Opel",
                "model", "Astra",
                "year_of_assembling", 2022,
                "shipping_addresses", List.of(address1, address2)
        );


        //expected
        Map<String, Object> expectedAddress1 = Map.of(
                "address", "Opelstr. 239",
                "city", "Opeltown",
                "zip", 55555,
                "telephoneNumbers", List.of("+49 30 1234567", "+49 30 7654321")
        );
        Map<String, Object> expectedAddress2 = Map.of(
                "address", "VWstr. 239",
                "city", "VWtown",
                "zip", 33333,
                "telephoneNumbers", List.of("+49 30 1111111", "+49 30 2222222")
        );
        Map<String, Object> expected = Map.of(
                "make", "Opel",
                "model", "Astra",
                "yearOfAssembling", 2022,
                "shippingAddresses", List.of(expectedAddress1, expectedAddress2));

        assertEquals(expected, solution.transformToCamelCase(json));
    }
}
