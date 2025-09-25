package POC;

import java.util.Scanner;

public class UserMenu {
    private ProductService productService;
    private Scanner scanner;

    public UserMenu(ProductService productService, Scanner scanner) {
        this.productService = productService;
        this.scanner = scanner;
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n===== 👤 USER MENU =====");
            System.out.println("1. View All Products");
            System.out.println("2. Search Product by Name");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    productService.viewProducts();
                    break;

                case 2:
                    System.out.print("Enter product name to search: ");
                    String keyword = scanner.nextLine();
                    productService.searchProduct(keyword);
                    break;

                case 3:
                    System.out.println("👋 Logging out from User Menu...");
                    break;

                default:
                    System.out.println("⚠ Invalid choice!");
            }
        } while (choice != 3);
    }
}

