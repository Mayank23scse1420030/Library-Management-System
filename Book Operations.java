import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookOperations {

    // Add a new book
    public static void addBook(String title, String author, String genre) {
        String query = "INSERT INTO books (title, author, genre) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, genre);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all books
    public static List<String> getBooks() {
        List<String> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String book = "ID: " + rs.getInt("book_id") + ", Title: " + rs.getString("title") + 
                              ", Author: " + rs.getString("author") + ", Genre: " + rs.getString("genre");
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    
    public static void issueBook(int bookId, int memberId) {
        String query = "INSERT INTO transactions (book_id, member_id, issue_date) VALUES (?, ?, CURDATE())";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, bookId);
            stmt.setInt(2, memberId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Return a book
    public static void returnBook(int transactionId) {
        String query = "UPDATE transactions SET return_date = CURDATE() WHERE transaction_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, transactionId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
