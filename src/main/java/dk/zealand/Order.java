package dk.zealand;

public class Order {
    private static int nextId = 1;

    private final int id;
    private final Dish dish;
    private final int quantity;
    private final OrderStatus status;

    public Order(Dish dish, int quantity) {
        this.id = nextId++;
        this.dish = dish;
        this.quantity = quantity;
        this.status = OrderStatus.MODTAGET;
    }

    public int getId() {
        return id;
    }

    public Dish getDish() {
        return dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Bestilling #" + id + ": " + dish.getName() + " x " + quantity + " (" + status + ")";
    }
}
