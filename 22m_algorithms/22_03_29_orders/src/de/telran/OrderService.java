package de.telran;

import java.util.*;

public class OrderService {

    /**
     * @param orders a list of orders
     * @param delta  time interval in millis
     * @return the number of orders from the same restaurant for every order for the previous delta millis before the oder.
     */
    public Map<String, Integer> countPreviousOrders(List<Order> orders, long delta) {
        List<Order> ordersCopy = new ArrayList<>(orders);
        ordersCopy.sort(Comparator.comparingLong(Order::getTimestamp));

        // mapping from restaurantId to the deque of the timestamps of the orders accommodated into the last delta milliseconds
        Map<String, Deque<Long>> orderTimesByRestaurantId = new HashMap<>();
        // mapping orderId to the number of previous orders of the same restaurant within delta milliseconds
        Map<String, Integer> res = new HashMap<>();

        for (Order order : ordersCopy) {
            Deque<Long> previousTimestamps = orderTimesByRestaurantId.get(order.getRestaurantId());
            if (previousTimestamps == null) {
                previousTimestamps = new ArrayDeque<>();
                orderTimesByRestaurantId.put(order.getRestaurantId(), previousTimestamps);
            }

            long currentTimestamp = order.getTimestamp();
            previousTimestamps.addLast(currentTimestamp);
            while (currentTimestamp - previousTimestamps.getFirst() > delta)
                previousTimestamps.removeFirst();

            res.put(order.getUuid(), previousTimestamps.size() - 1);
        }

        return res;

    }
}
