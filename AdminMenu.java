package POC;

import java.util.Scanner;

public class AdminMenu {
    private ProductService productService;
    private Scanner scanner;

    public AdminMenu(ProductService productService, Scanner scanner) {
        this.productService = productService;
        this.scanner = scanner;
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n===== 🛠 ADMIN MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    productService.addProduct(name, price, qty);
                    break;

                case 2:
                    productService.viewProducts();
                    break;

                case 3:
                    System.out.print("Enter product ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter new quantity: ");
                    int newQty = scanner.nextInt();
                    productService.updateProduct(id, newName, newPrice, newQty);
                    break;

                case 4:
                    System.out.print("Enter product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    productService.deleteProduct(deleteId);
                    break;

                case 5:
                    System.out.println("👋 Logging out from Admin Menu...");
                    break;

                default:
                    System.out.println("⚠ Invalid choice!");
            }
        } while (choice != 5);
    }
}

