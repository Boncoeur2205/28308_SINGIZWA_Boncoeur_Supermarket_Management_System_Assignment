package supermarket;

import java.util.Scanner;

public class SupermarketSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("   Welcome to the Supermarket System     ");
        System.out.println("=========================================");

        System.out.println("Enter customer ID: ");
        int customerID = getValidInt(scanner);
        System.out.println("Enter customer name: ");
        String customerName = getValidString(scanner);
        System.out.println("Enter phone number: ");
        String phoneNumber = getValidPhone(scanner);

        Customer customer = new Customer(customerID, customerName, phoneNumber);

        System.out.println("Enter product ID: ");
        int productID = getValidInt(scanner);
        System.out.println("Enter product name: ");
        String productName = getValidString(scanner);
        System.out.println("Enter product price: ");
        double price = getValidDouble(scanner);
        System.out.println("Enter product quantity: ");
        int quantity = getValidInt(scanner);
        System.out.println("Enter product category (food, beverage, electronic, clothing, cleaning, personalCare): ");
        String category = getValidCategory(scanner);
        System.out.println("Enter supplier name: ");
        String supplierName = getValidString(scanner);
        System.out.println("Enter storage location: ");
        String storageLocation = getValidString(scanner);
        System.out.println("Enter extra attribute (expiry date / volume / warranty months / size / composition / skin type): ");
        String extraAttribute = getValidString(scanner);

        Product product = ProductFactory.createProduct(productID, productName, price, quantity,
                category, supplierName, storageLocation, extraAttribute);


        if (product == null) {
            System.out.println("Error: Product creation failed. Unknown category.");
            scanner.close();
            return;
        }

        if (!product.validateProduct()) {
            System.out.println("Error: Product validation failed. Please check your inputs.");
            scanner.close();
            return;
        }

        System.out.println("Enter order ID: ");
        int orderID = getValidInt(scanner);
        System.out.println("Enter quantity to purchase: ");
        int purchaseQuantity = getValidInt(scanner);

        Order order = new Order(orderID, product, purchaseQuantity, 0);

        System.out.println("\n--- CUSTOMER DETAILS ---");
        System.out.println(customer);
        System.out.println("\n--- PRODUCT DETAILS ---");
        product.generateReport();
        System.out.println("\n--- ORDER SUMMARY ---");
        System.out.println(order);


        if (product instanceof InventoryManager inv) {
            inv.processSale(purchaseQuantity);
            System.out.println();
            inv.printReceipt(purchaseQuantity);
        }

        scanner.close();
    }

    private static int getValidInt(Scanner scanner) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (InputValidator.validatePositiveNumber(value)) return value;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }

    private static double getValidDouble(Scanner scanner) {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (InputValidator.validatePrice(value)) return value;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    public static String getValidString(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (InputValidator.validateString(input)) return input;
        }
    }

    private static String getValidPhone(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (InputValidator.validatePhoneNumber(input)) return input;
        }
    }

    public static String getValidCategory(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (InputValidator.validateCategory(input)) return input;
        }
    }
}
