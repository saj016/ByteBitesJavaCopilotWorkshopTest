package dk.zealand;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Menu MENU = new Menu();
    private static final OrderManager ORDER_MANAGER = new OrderManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("ByteBites – festivalens foodtruck");

        while (running) {
            showMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> showDishes();
                case "2" -> createOrder(scanner);
                case "0" -> running = false;
                default -> System.out.println(
                        "Ugyldigt valg. Vælg 0, 1 eller 2."
                );
            }
        }

        System.out.println("Programmet er afsluttet.");
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("1. Vis retter");
        System.out.println("2. Opret bestilling");
        System.out.println("0. Afslut");
        System.out.print("Vælg: ");
    }

    private static void showDishes() {
        System.out.println("Retter:");

        List<Dish> dishes = MENU.getDishes();
        for (int i = 0; i < dishes.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, dishes.get(i));
        }
    }

    private static void createOrder(Scanner scanner) {
        System.out.println("Vælg ret:");
        for (int i = 0; i < MENU.getDishes().size(); i++) {
            System.out.printf("%d. %s%n", i + 1, MENU.getDishes().get(i));
        }

        System.out.print("Ret: ");
        String dishChoice = scanner.nextLine().trim();

        Dish dish;
        try {
            int selectedDish = Integer.parseInt(dishChoice);
            dish = MENU.findDishByNumber(selectedDish);
        } catch (NumberFormatException e) {
            System.out.println("Ugyldig ret. Vælg 1, 2 eller 3.");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.print("Antal: ");
        String quantityInput = scanner.nextLine().trim();

        int quantity;
        try {
            quantity = Integer.parseInt(quantityInput);
        } catch (NumberFormatException e) {
            System.out.println("Ugyldigt antal. Indtast et positivt heltal.");
            return;
        }

        try {
            Order order = ORDER_MANAGER.createOrder(dish, quantity);
            System.out.println("Bestilling oprettet:");
            System.out.println(order);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
