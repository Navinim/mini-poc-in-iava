package POC;

import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private List<User> users = new ArrayList<>();

    public AuthService() {
        // Default admin account
        users.add(new User("admin", "admin123", "admin"));
    }

    // Register new user
    public void register(String username, String password) {
        // Check if username already exists
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("⚠ Username already taken. Choose another.");
                return;
            }
        }
        users.add(new User(username, password, "user"));
        System.out.println("✅ Registration successful! You can now login.");
    }

    // Login method
    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("✅ Login successful! Logged in as " + user.getRole());
                return user;
            }
        }
        System.out.println("❌ Invalid username or password!");
        return null;
    }
}

