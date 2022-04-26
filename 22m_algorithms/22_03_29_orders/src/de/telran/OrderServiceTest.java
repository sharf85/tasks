package de.telran;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService os = new OrderService();

    @Test
    public void test_countPreviousOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", 120, "1"));
        orders.add(new Order("2", 130, "2"));
        orders.add(new Order("3", 130, "1"));
        orders.add(new Order("4", 140, "2"));
        orders.add(new Order("5", 150, "1"));
        orders.add(new Order("6", 150, "2"));
        orders.add(new Order("7", 160, "2"));
        orders.add(new Order("8", 160, "1"));
        orders.add(new Order("9", 170, "1"));

        Map<String, Integer> expected = new HashMap<>();
        expected.put("1", 0);
        expected.put("2", 0);
        expected.put("3", 1);
        expected.put("4", 1);
        expected.put("5", 2);
        expected.put("6", 2);
        expected.put("7", 3);
        expected.put("8", 3);
        expected.put("9", 4);
        assertEquals(expected, os.countPreviousOrders(orders, 50));
    }

}
