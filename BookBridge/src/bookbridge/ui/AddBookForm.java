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
import bookbridge.model.Book;

import javax.swing.*;
import java.awt.*;

public class AddBookForm extends JFrame {

    private JTextField titleField;
    private JTextField authorField;

    public AddBookForm() {

        setTitle("Add Book");
        setSize(350, 200);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 2));

        add(new JLabel("Title:"));
        titleField = new JTextField();
        add(titleField);

        add(new JLabel("Author:"));
        authorField = new JTextField();
        add(authorField);

        JButton saveButton =
                new JButton("Save");

        add(saveButton);

        saveButton.addActionListener(e -> saveBook());

        setVisible(true);
    }

    private void saveBook() {

        String title =
                titleField.getText();

        String author =
                authorField.getText();

        if (title.isEmpty() || author.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please complete all fields."
            );

            return;
        }

        Book book =
                new Book(
                        0,
                        title,
                        author,
                        true
                );

        BookDAO dao =
                new BookDAO();

        if (dao.addBook(book)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Book Added Successfully!"
            );

            titleField.setText("");
            authorField.setText("");

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Failed To Add Book."
            );
        }
    }
}
