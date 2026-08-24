package dk.zealand;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private static final int MAX_ORDERS = 10;

    private final List<Order> orders = new ArrayList<>();

    public Order createOrder(Dish dish, int quantity) {
        if (orders.size() >= MAX_ORDERS) {
            throw new IllegalStateException("Der kan højst gemmes ti bestillinger.");
        }
        if (dish == null) {
            throw new IllegalArgumentException("Ugyldig ret. Vælg 1, 2 eller 3.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Antal skal være et positivt tal.");
        }

        Order order = new Order(dish, quantity);
        orders.add(order);
        return order;
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }
}
