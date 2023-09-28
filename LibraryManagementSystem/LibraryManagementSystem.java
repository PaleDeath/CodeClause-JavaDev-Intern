import java.sql.*;
import java.util.Scanner;

public class LibraryManagementSystem {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/library";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isStudent = false;
        boolean isAdmin = false;
        int studentId = -1; // Declare and initialize studentId here

        // Connect to the database
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement statement = connection.createStatement();
            initializeDatabase(statement);
            clearScreen();
            System.out.println("Welcome to the Library System!");

            while (true) {
                if (!isStudent && !isAdmin) {
                    System.out.println("Main Menu:");
                    System.out.println("1. Admin login");
                    System.out.println("2. Student login");
                    System.out.println("3. Exit");
                    choice = getIntegerInput("Enter your choice: ");
                    clearScreen();
                    switch (choice) {
                        case 1:
                            // Admin login
                            String adminPassword = getPasswordInput("Enter admin password: ");
                            if (adminPassword.equals("1234")) {
                                isAdmin = true;
                                System.out.println("Admin login successful");
                            } else {
                                System.out.println("Incorrect password");
                            }
                            break;
                        case 2:
                            // Student login
                            studentId = getIntegerInput("Enter student ID: "); // Initialize studentId here
                            ResultSet studentResultSet = statement
                                    .executeQuery("SELECT * FROM Students WHERE id = " + studentId);
                            if (studentResultSet.next()) {
                                isStudent = true;
                                System.out.println("Student login successful");
                            } else {
                                System.out.println("Student not found");
                            }
                            break;
                        case 3:
                            System.out.println("Exiting program");
                            return;
                        default:
                            System.out.println("Invalid choice");
                    }
                } else if (isStudent) {
                    System.out.println("Student Menu:");
                    System.out.println("1. Borrow a book");
                    System.out.println("2. Return a book");
                    System.out.println("3. View available books");
                    System.out.println("4. Logout");
                    choice = getIntegerInput("Enter your choice: ");
                    clearScreen();
                    switch (choice) {
                        case 1:
                            System.out.print("Enter book ID: ");
                            int bookId = getIntegerInput("");
                            ResultSet bookResultSet = statement
                                    .executeQuery("SELECT * FROM Books WHERE id = " + bookId);
                            if (bookResultSet.next() && bookResultSet.getBoolean("is_available")) {
                                statement.executeUpdate("UPDATE Books SET is_available = false WHERE id = " + bookId);
                                statement.executeUpdate(
                                        "UPDATE Students SET books_issued = books_issued + 1 WHERE id = " + studentId);
                                System.out.println("Book borrowed successfully");
                            } else {
                                System.out.println("Book not available");
                            }
                            break;
                        case 2:
                            ResultSet issuedBooksResultSet = statement
                                    .executeQuery("SELECT * FROM Students WHERE id = " + studentId);
                            if (issuedBooksResultSet.next() && issuedBooksResultSet.getInt("books_issued") > 0) {
                                System.out.print("Enter book ID: ");
                                int returnBookId = getIntegerInput("");
                                ResultSet returnBookResultSet = statement
                                        .executeQuery("SELECT * FROM Books WHERE id = " + returnBookId);
                                if (returnBookResultSet.next() && !returnBookResultSet.getBoolean("is_available")) {
                                    statement.executeUpdate(
                                            "UPDATE Books SET is_available = true WHERE id = " + returnBookId);
                                    statement.executeUpdate(
                                            "UPDATE Students SET books_issued = books_issued - 1 WHERE id = "
                                                    + studentId);
                                    System.out.println("Book returned successfully");
                                } else {
                                    System.out.println("Invalid book ID");
                                }
                            } else {
                                System.out.println("No books issued");
                            }
                            break;
                        case 3:
                            // View available books for students
                            viewAvailableBooks(statement);
                            break;
                        case 4:
                            isStudent = false;
                            System.out.println("Logged out successfully");
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                } else if (isAdmin) {
                    System.out.println("Admin Menu:");
                    System.out.println("1. Add a book");
                    System.out.println("2. Remove a book");
                    System.out.println("3. View available books");
                    System.out.println("4. Logout");
                    choice = getIntegerInput("Enter your choice: ");
                    clearScreen();
                    switch (choice) {
                        case 1:
                            System.out.print("Enter book ID: ");
                            int addBookId = getIntegerInput("");
                            System.out.print("Enter book title: ");
                            String addBookTitle = scanner.nextLine();
                            System.out.print("Enter book author: ");
                            String addBookAuthor = scanner.nextLine();
                            statement.executeUpdate("INSERT INTO Books (id, title, author, is_available) VALUES ("
                                    + addBookId + ", '" + addBookTitle + "', '" + addBookAuthor + "', true)");
                            System.out.println("Book added successfully");
                            break;
                        case 2:
                            System.out.print("Enter book ID: ");
                            int removeBookId = getIntegerInput("");
                            statement.executeUpdate("DELETE FROM Books WHERE id = " + removeBookId);
                            System.out.println("Book removed successfully");
                            break;
                        case 3:
                            // View available books for admins
                            viewAvailableBooks(statement);
                            break;
                        case 4:
                            isAdmin = false;
                            System.out.println("Logged out successfully");
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    // Helper method to initialize the database and create tables if they do not
    // exist
    private static void initializeDatabase(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Books (id INT PRIMARY KEY, title VARCHAR(50), author VARCHAR(50), is_available BOOLEAN)");
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Students (id INT PRIMARY KEY, name VARCHAR(50), books_issued INT)");
    }

    // Helper method to clear the console screen
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Helper method to get integer input from the user
    private static int getIntegerInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return input;
    }

    // Helper method to get a password input without displaying it on the console
    private static String getPasswordInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Helper method to view available books
    private static void viewAvailableBooks(Statement statement) throws SQLException {
        ResultSet availableBooksResultSet = statement.executeQuery("SELECT * FROM Books WHERE is_available = true");
        System.out.println("Available Books:");
        while (availableBooksResultSet.next()) {
            System.out.println("Book ID: " + availableBooksResultSet.getInt("id"));
            System.out.println("Title: " + availableBooksResultSet.getString("title"));
            System.out.println("Author: " + availableBooksResultSet.getString("author"));
            System.out.println();
        }
    }
}
