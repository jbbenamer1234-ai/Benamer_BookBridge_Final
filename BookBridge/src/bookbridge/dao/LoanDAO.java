/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookbridge.dao;

/**
 *
 * @author Juan Benamer
 */
import bookbridge.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LoanDAO {

    public boolean issueBook(int memberId, int bookId) {

        try {

            Connection conn =
                    DBConnection.getConnection();

            String checkBook =
                    "SELECT available FROM books WHERE book_id = ?";

            PreparedStatement checkStmt =
                    conn.prepareStatement(checkBook);

            checkStmt.setInt(1, bookId);

            var rs =
                    checkStmt.executeQuery();

            if (!rs.next()) {

                System.out.println("Book not found.");

                conn.close();

                return false;
            }

            boolean available =
                    rs.getBoolean("available");

            if (!available) {

                System.out.println("Book already issued.");

                conn.close();

                return false;
            }

            String loanSql =
                    "INSERT INTO loans(member_id, book_id) VALUES(?,?)";

            PreparedStatement loanStmt =
                    conn.prepareStatement(loanSql);

            loanStmt.setInt(1, memberId);
            loanStmt.setInt(2, bookId);

            loanStmt.executeUpdate();

            String updateBook =
                    "UPDATE books SET available = false WHERE book_id = ?";

            PreparedStatement updateStmt =
                    conn.prepareStatement(updateBook);

            updateStmt.setInt(1, bookId);

            updateStmt.executeUpdate();

            conn.close();

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Issue Book Error: "
                            + e.getMessage()
            );

            return false;
        }
    }
    
    public boolean returnBook(int bookId) {

    try {

        Connection conn =
                DBConnection.getConnection();

        String updateBook =
                "UPDATE books SET available = true WHERE book_id = ?";

        PreparedStatement updateStmt =
                conn.prepareStatement(updateBook);

        updateStmt.setInt(1, bookId);

        int updated =
                updateStmt.executeUpdate();

        String deleteLoan =
                "DELETE FROM loans WHERE book_id = ?";

        PreparedStatement deleteStmt =
                conn.prepareStatement(deleteLoan);

        deleteStmt.setInt(1, bookId);

        deleteStmt.executeUpdate();

        conn.close();

        return updated > 0;

    } catch (Exception e) {

        System.out.println(
                "Return Book Error: "
                        + e.getMessage()
        );

        return false;
    }
}

    
}
