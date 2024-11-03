import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String[][] menu = {
        {"French Bread", "Roll Bread", "Burger Bun", "Pita Bread"},
        {"Coalho Cheese", "Minas Cheese", "Mozzarella", "Cream Cheese", "Gorgonzola"},
        {"Mortadella", "Ham", "Bacon", "Smoked Ham", "Pepperoni", "Salami"},
        {"Onion", "Bell Pepper", "Tomato"},
        {"Mayonnaise", "Ketchup", "Seasoned Mayo", "Tartar Sauce", "Barbecue"},
        {"Potato Sticks", "Egg"}
    };

    private static double[][] prices = {
        {0.25, 0.30, 0.70, 1.30},
        {1.50, 1.80, 2.00, 3.00, 3.50},
        {0.50, 1.00, 1.30, 1.60, 1.80, 2.00},
        {0.30, 0.45, 0.50},
        {0.50, 0.50, 0.70, 1.00, 1.50},
        {1.00, 1.00}
    };

    private static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("OPTION MENU:");
        System.out.println("1. Breads");
        System.out.println("2. Cheeses");
        System.out.println("3. Meats");
        System.out.println("4. Vegetables");
        System.out.println("5. Sauces");
        System.out.println("6. Others");
        System.out.println("7. Exit");
    }

    public static void line() {
        System.out.println("----------------------------------");
    }

    public static void showMenu(int option) {
        if (option >= 1 && option <= 6) {
            System.out.println("Products:");
            for (int i = 0; i < menu[option - 1].length; i++) {
                System.out.printf("%d. %s - $ %.2f%n", i + 1, menu[option - 1][i], prices[option - 1][i]);
            }
        } else {
            System.out.println("Invalid option!");
        }
    }

    public static int getInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        int response = 0, product;
        double total = 0;

        List<String> orderedItems = new ArrayList<>();
        List<Double> itemPrices = new ArrayList<>();

        while (response != 7) {
            mainMenu();
            response = getInput("Which option do you want?: ");

            if (response >= 1 && response <= 6) {
                line();
                showMenu(response);
                product = getInput("Select a product: ");
                if (product >= 1 && product <= menu[response - 1].length) {
                    String selectedItem = menu[response - 1][product - 1];
                    double selectedPrice = prices[response - 1][product - 1];
                    orderedItems.add(selectedItem);
                    itemPrices.add(selectedPrice);
                    total += selectedPrice;
                    System.out.printf("%s added\n", selectedItem);
                } else {
                    System.out.println("Invalid product selection.");
                }
                line();
            } else if (response == 7) {
                line();
                System.out.println("Your order is:");
                System.out.println(orderedItems);
                System.out.printf("The total is $ %.2f%n", total);
                System.out.print("Do you want to exit? [Y/N]: ");
                String exit = scanner.next();
                if (exit.equalsIgnoreCase("N")) {
                    response = 0;
                }
            }
        }

        line();
        System.out.println("Your final order was:");
        for (int i = 0; i < orderedItems.size(); i++) {
            System.out.printf("%d. %s - $ %.2f%n", i + 1, orderedItems.get(i), itemPrices.get(i));
        }
        System.out.printf("The total was $ %.2f%n", total);

        scanner.close();
    }
}