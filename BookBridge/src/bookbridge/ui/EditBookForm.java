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

public class EditBookForm extends JFrame {

    private JTextField idField;
    private JTextField titleField;
    private JTextField authorField;

    public EditBookForm() {

        setTitle("Edit Book");
        setSize(350,200);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4,2));

        add(new JLabel("Book ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("New Title:"));
        titleField = new JTextField();
        add(titleField);

        add(new JLabel("New Author:"));
        authorField = new JTextField();
        add(authorField);

        JButton button =
                new JButton("Update");

        add(button);

        button.addActionListener(e ->
                updateBook());

        setVisible(true);
    }

    private void updateBook() {

        try {

            int id =
                    Integer.parseInt(
                            idField.getText()
                    );

            BookDAO dao =
                    new BookDAO();

            if (dao.updateBook(
                    id,
                    titleField.getText(),
                    authorField.getText()
            )) {

                JOptionPane.showMessageDialog(
                        this,
                        "Book Updated Successfully!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Update Failed!"
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
