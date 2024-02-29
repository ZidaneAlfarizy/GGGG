import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private HashMap<String, HashMap<String, String>> users;

    public Main() {
        users = new HashMap<>();
        users.put("202310370311058", new HashMap<String, String>() {{
            put("name", "Zidane Alfarizy");
            put("role", "Student");
        }});
        users.put("admin", new HashMap<String, String>() {{
            put("username", "admin");
            put("password", "admin");
            put("role", "Admin");
        }});
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                if (login("Student")) {
                    studentMenu(scanner);
                }
            } else if (choice.equals("2")) {
                if (login("Admin")) {
                    adminMenu(scanner);
                }
            } else if (choice.equals("3")) {
                System.out.println("Good Bye");
                break;
            } else {
                System.out.println("Invalid option, please choose again.");
            }
        }
        scanner.close();
    }

    private boolean login(String role) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your " + (role.equals("Student") ? "NIM" : "username") + ": ");
        String identifier = scanner.nextLine();
        if (users.containsKey(identifier)) {
            if (users.get(identifier).get("role").equals(role)) {
                if (role.equals("Admin")) {
                    System.out.print("Enter your password (admin): ");
                    String password = scanner.nextLine();
                    if (password.equals(users.get(identifier).get("password"))) {
                        System.out.println("Successful Login as " + role);
                        return true;
                    } else {
                        System.out.println(role + " User Not Found!!");
                        return false;
                    }
                } else {
                    System.out.println("Successful Login as " + role);
                    return true;
                }
            }
        }
        System.out.println(role + " User Not Found!!");
        return false;
    }

    private void studentMenu(Scanner scanner) {
        // Student menu logic here
    }

    private void adminMenu(Scanner scanner) {
        // Admin menu logic here
    }

    public static void main(String[] args) {
        Main Main = new Main();
        Main.run();
    }
}