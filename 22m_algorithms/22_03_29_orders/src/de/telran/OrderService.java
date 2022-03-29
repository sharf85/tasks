package de.telran;

import java.util.List;
import java.util.Map;

public class OrderService {

    /**
     *
     * @param orders a list of orders
     * @param delta time interval in millis
     * @return the number of orders from the same restaurant for every order for the previous delta millis before the oder.
     */
    public Map<String, Integer> countPreviousOrders(List<Order> orders, long delta) {
        //todo implement
    }
}
