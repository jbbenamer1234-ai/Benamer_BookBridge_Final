/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookbridge.ui;

/**
 *
 * @author Juan Benamer
 */
import bookbridge.dao.LoanDAO;

import javax.swing.*;
import java.awt.*;

public class IssueBookForm extends JFrame {

    private JTextField memberField;
    private JTextField bookField;

    public IssueBookForm() {

        setTitle("Issue Book");
        setSize(300,200);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3,2));

        add(new JLabel("Member ID:"));
        memberField = new JTextField();
        add(memberField);

        add(new JLabel("Book ID:"));
        bookField = new JTextField();
        add(bookField);

        JButton issueButton = new JButton("Issue");
        add(issueButton);

        issueButton.addActionListener(e -> issueBook());

        setVisible(true);
    }

    private void issueBook() {

        try {

            int memberId =
                    Integer.parseInt(memberField.getText());

            int bookId =
                    Integer.parseInt(bookField.getText());

            LoanDAO dao =
                    new LoanDAO();

            if (dao.issueBook(memberId, bookId)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Book Issued Successfully!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Issue Failed!"
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