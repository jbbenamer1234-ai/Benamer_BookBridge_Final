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

public class EditMemberForm extends JFrame {

    private JTextField idField;
    private JTextField nameField;

    public EditMemberForm() {

        setTitle("Edit Member");
        setSize(350, 200);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 2));

        add(new JLabel("Member ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("New Name:"));
        nameField = new JTextField();
        add(nameField);

        JButton updateButton =
                new JButton("Update");

        add(updateButton);

        updateButton.addActionListener(e ->
                updateMember());

        setVisible(true);
    }

    private void updateMember() {

        try {

            int id = Integer.parseInt(
                    idField.getText());

            MemberDAO dao =
                    new MemberDAO();

            boolean success =
                    dao.updateMember(
                            id,
                            nameField.getText());

            if (success) {

                JOptionPane.showMessageDialog(
                        this,
                        "Member Updated Successfully!");

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Update Failed!");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Input!");
        }
    }
}
