/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookbridge.ui;

/**
 *
 * @author Juan Benamer
 */
import bookbridge.dao.MemberDAO;

import javax.swing.*;
import java.awt.*;

public class DeleteMemberForm extends JFrame {

    private JTextField memberField;

    public DeleteMemberForm() {

        setTitle("Delete Member");
        setSize(300,150);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(2,2));

        add(new JLabel("Member ID:"));

        memberField =
                new JTextField();

        add(memberField);

        JButton button =
                new JButton("Delete");

        add(button);

        button.addActionListener(e ->
                deleteMember());

        setVisible(true);
    }

    private void deleteMember() {

        try {

            int memberId =
                    Integer.parseInt(
                            memberField.getText()
                    );

            MemberDAO dao =
                    new MemberDAO();

            if (dao.deleteMember(memberId)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Member Deleted Successfully!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Delete Failed!"
                );
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Input!"
            );
        }
    }
}