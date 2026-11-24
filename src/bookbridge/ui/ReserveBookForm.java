/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookbridge.ui;

/**
 *
 * @author Juan Benamer
 */
import bookbridge.service.ReservationService;

import javax.swing.*;
import java.awt.*;

public class ReserveBookForm extends JFrame {

    private JTextField memberField;
    private JTextField bookField;

    public ReserveBookForm() {

        setTitle("Reserve Book");
        setSize(300,200);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3,2));

        add(new JLabel("Member ID:"));
        memberField = new JTextField();
        add(memberField);

        add(new JLabel("Book ID:"));
        bookField = new JTextField();
        add(bookField);

        JButton button =
                new JButton("Reserve");

        add(button);

        button.addActionListener(e ->
                reserveBook());

        setVisible(true);
    }

    private void reserveBook() {

        try {

            int memberId =
                    Integer.parseInt(memberField.getText());

            int bookId =
                    Integer.parseInt(bookField.getText());

            ReservationService service =
                    new ReservationService();

            if (service.reserveBook(
                    memberId,
                    bookId
            )) {

                JOptionPane.showMessageDialog(
                        this,
                        "Reservation Successful!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Reservation Failed!"
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
