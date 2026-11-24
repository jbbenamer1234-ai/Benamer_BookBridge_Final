/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookbridge.reporting;

/**
 *
 * @author Juan Benamer
 */
import bookbridge.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReportGenerator {

    public String generateReport() {

        try {

            Connection conn =
                    DBConnection.getConnection();

            int books = getCount(conn, "SELECT COUNT(*) FROM books");
            int members = getCount(conn, "SELECT COUNT(*) FROM members");
            int loans = getCount(conn, "SELECT COUNT(*) FROM loans");
            int reservations = getCount(conn, "SELECT COUNT(*) FROM reservations");

            conn.close();

            return
                    "===== BOOKBRIDGE REPORT =====\n\n"
                    + "Total Books: " + books + "\n"
                    + "Total Members: " + members + "\n"
                    + "Total Loans: " + loans + "\n"
                    + "Total Reservations: " + reservations;

        } catch (Exception e) {

            return
                    "Report Error: "
                    + e.getMessage();
        }
    }

    private int getCount(Connection conn, String sql)
            throws Exception {

        PreparedStatement pst =
                conn.prepareStatement(sql);

        ResultSet rs =
                pst.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return 0;
    }
}