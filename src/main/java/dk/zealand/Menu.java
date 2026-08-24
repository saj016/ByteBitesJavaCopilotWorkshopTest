package dk.zealand;

import java.util.List;

public class Menu {
    private final List<Dish> dishes;

    public Menu() {
        this.dishes = List.of(
                new Dish("Festivalburger", 59),
                new Dish("Sprøde fritter", 35),
                new Dish("Vegansk bowl", 65)
        );
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Dish findDishByNumber(int number) {
        if (number < 1 || number > dishes.size()) {
            throw new IllegalArgumentException("Ugyldig ret. Vælg 1, 2 eller 3.");
        }
        return dishes.get(number - 1);
    }
}
