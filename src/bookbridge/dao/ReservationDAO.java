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

public class ReservationDAO {

    public boolean reserveBook(int memberId, int bookId) {

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO reservations(member_id, book_id) VALUES(?,?)";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, memberId);
            pst.setInt(2, bookId);

            pst.executeUpdate();

            conn.close();

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Reservation Error: "
                            + e.getMessage()
            );

            return false;
        }
    }
    
    public boolean cancelReservation(int reservationId) {

    try {

        Connection conn =
                DBConnection.getConnection();

        String sql =
                "DELETE FROM reservations WHERE reservation_id = ?";

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setInt(1, reservationId);

        int deleted =
                pst.executeUpdate();

        conn.close();

        return deleted > 0;

    } catch (Exception e) {

        System.out.println(
                "Cancel Reservation Error: "
                        + e.getMessage()
        );

        return false;
    }
}
    
    public String processNextReservation() {

    try {

        Connection conn =
                DBConnection.getConnection();

        String sql =
                "SELECT * FROM reservations ORDER BY reservation_id LIMIT 1";

        PreparedStatement pst =
                conn.prepareStatement(sql);

        var rs =
                pst.executeQuery();

        if (rs.next()) {

            int reservationId =
                    rs.getInt("reservation_id");

            int memberId =
                    rs.getInt("member_id");

            int bookId =
                    rs.getInt("book_id");

            PreparedStatement deleteStmt =
                    conn.prepareStatement(
                            "DELETE FROM reservations WHERE reservation_id=?"
                    );

            deleteStmt.setInt(
                    1,
                    reservationId
            );

            deleteStmt.executeUpdate();

            conn.close();

            return
                    "Processed Reservation\n\n"
                    + "Reservation ID: "
                    + reservationId
                    + "\nMember ID: "
                    + memberId
                    + "\nBook ID: "
                    + bookId;
        }

        conn.close();

        return "No reservations in queue.";

    } catch (Exception e) {

        return
                "Queue Processing Error:\n"
                + e.getMessage();
    }
}
}