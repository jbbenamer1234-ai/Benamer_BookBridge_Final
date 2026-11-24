/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookbridge.dao;

/**
 *
 * @author Juan Benamer
 */
import bookbridge.model.Book;
import bookbridge.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList; 

public class BookDAO {

    public boolean addBook(Book book) {

        String sql =
                "INSERT INTO books(title, author, available) VALUES(?,?,?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, book.getTitle());
            pst.setString(2, book.getAuthor());
            pst.setBoolean(3, book.isAvailable());

            pst.executeUpdate();

            conn.close();

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Error adding book: "
                            + e.getMessage()
            );

            return false;
        }
    }
    
    public void viewBooks() {

    String sql = "SELECT * FROM books";

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        var rs = pst.executeQuery();

        System.out.println("\nBOOK LIST");

        while (rs.next()) {

            System.out.println(
                    rs.getInt("book_id")
                    + " | "
                    + rs.getString("title")
                    + " | "
                    + rs.getString("author")
                    + " | "
                    + rs.getBoolean("available")
            );
        }

        conn.close();

    } catch (Exception e) {

        System.out.println(
                "Error viewing books: "
                + e.getMessage()
        );
    }
}
    public ArrayList<String> getBooks() {

    ArrayList<String> books = new ArrayList<>();

    String sql = "SELECT * FROM books";

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        var rs = pst.executeQuery();

        while (rs.next()) {

            books.add(
                    rs.getInt("book_id")
                    + " | "
                    + rs.getString("title")
                    + " | "
                    + rs.getString("author")
                    + " | "
                    + rs.getBoolean("available")
            );
        }

        conn.close();

    } catch (Exception e) {

        System.out.println(
                "Error getting books: "
                        + e.getMessage()
        );
    }

    return books;
}
    public ArrayList<String> searchBooks(String keyword) {

    ArrayList<String> books = new ArrayList<>();

    String sql =
            "SELECT * FROM books WHERE title LIKE ?";

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setString(
                1,
                "%" + keyword + "%"
        );

        var rs =
                pst.executeQuery();

        while (rs.next()) {

            books.add(
                    rs.getInt("book_id")
                    + " | "
                    + rs.getString("title")
                    + " | "
                    + rs.getString("author")
                    + " | "
                    + rs.getBoolean("available")
            );
        }

        conn.close();

    } catch (Exception e) {

        System.out.println(
                "Search Error: "
                        + e.getMessage()
        );
    }

    return books;
}
    public ArrayList<String> sortBooks() {

    ArrayList<String> books =
            new ArrayList<>();

    String sql =
            "SELECT * FROM books ORDER BY title";

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        var rs =
                pst.executeQuery();

        while (rs.next()) {

            books.add(
                    rs.getInt("book_id")
                    + " | "
                    + rs.getString("title")
                    + " | "
                    + rs.getString("author")
            );
        }

        conn.close();

    } catch (Exception e) {

        System.out.println(
                e.getMessage()
        );
    }

    return books;
}
    public boolean deleteBook(int bookId) {

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement deleteLoans =
                conn.prepareStatement(
                        "DELETE FROM loans WHERE book_id=?"
                );

        deleteLoans.setInt(1, bookId);
        deleteLoans.executeUpdate();

        PreparedStatement deleteReservations =
                conn.prepareStatement(
                        "DELETE FROM reservations WHERE book_id=?"
                );

        deleteReservations.setInt(1, bookId);
        deleteReservations.executeUpdate();

        PreparedStatement deleteBook =
                conn.prepareStatement(
                        "DELETE FROM books WHERE book_id=?"
                );

        deleteBook.setInt(1, bookId);

        int deleted =
                deleteBook.executeUpdate();

        conn.close();

        return deleted > 0;

    } catch (Exception e) {

        System.out.println(
                "Delete Book Error: "
                        + e.getMessage()
        );

        return false;
    }
}
    public boolean updateBook(
        int bookId,
        String title,
        String author
) {

    try {

        Connection conn =
                DBConnection.getConnection();

        String sql =
                "UPDATE books SET title=?, author=? WHERE book_id=?";

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setString(1, title);
        pst.setString(2, author);
        pst.setInt(3, bookId);

        int updated =
                pst.executeUpdate();

        conn.close();

        return updated > 0;

    } catch (Exception e) {

        System.out.println(
                "Update Book Error: "
                        + e.getMessage()
        );

        return false;
    }
}

}