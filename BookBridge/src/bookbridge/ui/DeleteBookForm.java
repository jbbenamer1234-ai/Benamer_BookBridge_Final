/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookbridge.ui;

/**
 *
 * @author Juan Benamer
 */
import bookbridge.dao.BookDAO;

import javax.swing.*;
import java.awt.*;

public class DeleteBookForm extends JFrame {

    private JTextField bookIdField;

    public DeleteBookForm() {

        setTitle("Delete Book");
        setSize(300,150);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(2,2));

        add(new JLabel("Book ID:"));

        bookIdField =
                new JTextField();

        add(bookIdField);

        JButton deleteButton =
                new JButton("Delete");

        add(deleteButton);

        deleteButton.addActionListener(e ->
                deleteBook());

        setVisible(true);
    }

    private void deleteBook() {

        try {

            int bookId =
                    Integer.parseInt(
                            bookIdField.getText()
                    );

            BookDAO dao =
                    new BookDAO();

            if (dao.deleteBook(bookId)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Book Deleted Successfully!"
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
