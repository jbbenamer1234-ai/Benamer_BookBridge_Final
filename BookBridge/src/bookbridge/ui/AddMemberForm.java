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
import bookbridge.model.Member;

import javax.swing.*;
import java.awt.*;

public class AddMemberForm extends JFrame {

    private JTextField nameField;

    public AddMemberForm() {

        setTitle("Add Member");
        setSize(300,150);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(2,2));

        add(new JLabel("Name:"));

        nameField = new JTextField();
        add(nameField);

        JButton saveButton =
                new JButton("Save");

        add(saveButton);

        saveButton.addActionListener(e ->
                saveMember());

        setVisible(true);
    }

    private void saveMember() {

        String name =
                nameField.getText();

        if (name.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a name."
            );

            return;
        }

        Member member =
                new Member(
                        0,
                        name
                );

        MemberDAO dao =
                new MemberDAO();

        if (dao.addMember(member)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Member Added Successfully!"
            );

            nameField.setText("");

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Failed To Add Member."
            );
        }
    }
}