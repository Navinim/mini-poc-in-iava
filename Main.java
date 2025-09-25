package POC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();
        ProductService productService = new ProductService();

        int choice;
        do {
            System.out.println("\n===== 📦 PRODUCT MANAGEMENT SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String regUser = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String regPass = scanner.nextLine();
                    authService.register(regUser, regPass);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String loginUser = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPass = scanner.nextLine();

                    User loggedIn = authService.login(loginUser, loginPass);
                    if (loggedIn != null) {
                        if (loggedIn.getRole().equals("admin")) {
                            AdminMenu adminMenu = new AdminMenu(productService, scanner);
                            adminMenu.showMenu();
                        } else {
                            UserMenu userMenu = new UserMenu(productService, scanner);
                            userMenu.showMenu();
                        }
                    }
                    break;

                case 3:
                    System.out.println("👋 Exiting system... Goodbye!");
                    break;

                default:
                    System.out.println("⚠ Invalid choice!");
            }
        } while (choice != 3);

        scanner.close();
    }
}

