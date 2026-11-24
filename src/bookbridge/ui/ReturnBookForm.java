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

public class ReturnBookForm extends JFrame {

    private JTextField bookField;

    public ReturnBookForm() {

        setTitle("Return Book");
        setSize(300,150);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(2,2));

        add(new JLabel("Book ID:"));

        bookField = new JTextField();
        add(bookField);

        JButton button =
                new JButton("Return");

        add(button);

        button.addActionListener(e ->
                returnBook());

        setVisible(true);
    }

    private void returnBook() {

        try {

            int bookId =
                    Integer.parseInt(bookField.getText());

            LoanDAO dao =
                    new LoanDAO();

            if (dao.returnBook(bookId)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Book Returned Successfully!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Return Failed!"
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
