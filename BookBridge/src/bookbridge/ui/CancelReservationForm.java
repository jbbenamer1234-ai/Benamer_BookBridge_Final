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

public class CancelReservationForm extends JFrame {

    private JTextField reservationField;

    public CancelReservationForm() {

        setTitle("Cancel Reservation");
        setSize(300,150);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(2,2));

        add(new JLabel("Reservation ID:"));

        reservationField =
                new JTextField();

        add(reservationField);

        JButton button =
                new JButton("Cancel");

        add(button);

        button.addActionListener(e ->
                cancelReservation());

        setVisible(true);
    }

    private void cancelReservation() {

        try {

            int reservationId =
                    Integer.parseInt(
                            reservationField.getText()
                    );

            ReservationService service =
                    new ReservationService();

            if (service.cancelReservation(
                    reservationId
            )) {

                JOptionPane.showMessageDialog(
                        this,
                        "Reservation Cancelled!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Cancellation Failed!"
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