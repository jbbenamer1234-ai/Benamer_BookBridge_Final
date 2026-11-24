/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookbridge.dao;

/**
 *
 * @author Juan Benamer
 */
import bookbridge.model.Member;
import bookbridge.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class MemberDAO {

    public boolean addMember(Member member) {

        String sql =
                "INSERT INTO members(name) VALUES(?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, member.getName());

            pst.executeUpdate();

            conn.close();

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Error adding member: "
                            + e.getMessage()
            );

            return false;
        }
    }

    public void viewMembers() {

        String sql = "SELECT * FROM members";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            var rs = pst.executeQuery();

            System.out.println("\nMEMBER LIST");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("member_id")
                        + " | "
                        + rs.getString("name")
                );
            }

            conn.close();

        } catch (Exception e) {

            System.out.println(
                    "Error viewing members: "
                            + e.getMessage()
            );
        }
    }
    public ArrayList<String> getMembers() {

    ArrayList<String> members = new ArrayList<>();

    String sql = "SELECT * FROM members";

    try {

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        var rs = pst.executeQuery();

        while (rs.next()) {

            members.add(
                    rs.getInt("member_id")
                    + " | "
                    + rs.getString("name")
            );
        }

        conn.close();

    } catch (Exception e) {

        System.out.println(
                "Error getting members: "
                        + e.getMessage()
        );
    }

    return members;
}
    public boolean deleteMember(int memberId) {

    try {

        Connection conn =
                DBConnection.getConnection();

        String sql =
                "DELETE FROM members WHERE member_id=?";

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setInt(1, memberId);

        int deleted =
                pst.executeUpdate();

        conn.close();

        return deleted > 0;

    } catch (Exception e) {

        System.out.println(
                "Delete Member Error: "
                + e.getMessage()
        );

        return false;
    }
}
    
    public boolean updateMember(
        int memberId,
        String name) {

    String sql =
            "UPDATE members SET name=? WHERE member_id=?";

    try (
        Connection conn =
                DBConnection.getConnection();

        PreparedStatement stmt =
                conn.prepareStatement(sql)
    ) {

        stmt.setString(1, name);
        stmt.setInt(2, memberId);

        return stmt.executeUpdate() > 0;

    } catch (Exception e) {

        e.printStackTrace();

        return false;
    }
}

    
}
