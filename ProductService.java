package POC;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();
    private int nextId = 1;

    // Add product (Admin only)
    public void addProduct(String name, double price, int quantity) {
        Product p = new Product(nextId++, name, price, quantity);
        products.add(p);
        System.out.println("✅ Product added successfully: " + p);
    }

    // View all products
    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("⚠ No products available.");
            return;
        }
        System.out.println("📦 Product List:");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    // Update product by ID
    public void updateProduct(int id, String newName, double newPrice, int newQty) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(newName);
                p.setPrice(newPrice);
                p.setQuantity(newQty);
                System.out.println("✅ Product updated successfully.");
                return;
            }
        }
        System.out.println("❌ Product not found!");
    }

    // Delete product by ID
    public void deleteProduct(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                products.remove(p);
                System.out.println("✅ Product deleted successfully.");
                return;
            }
        }
        System.out.println("❌ Product not found!");
    }

    // Search product by name (User)
    public void searchProduct(String keyword) {
        boolean found = false;
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("⚠ No matching products found.");
        }
    }
}
