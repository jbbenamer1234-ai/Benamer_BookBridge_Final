/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookbridge.service;

/**
 *
 * @author Juan Benamer
 */
import bookbridge.dao.ReservationDAO;

public class ReservationService {

    private ReservationDAO dao =
            new ReservationDAO();

    public boolean reserveBook(int memberId, int bookId) {

        return dao.reserveBook(memberId, bookId);
    }
    
    public boolean cancelReservation(int reservationId) {

    return dao.cancelReservation(
            reservationId
    );
}
    
    public String processNextReservation() {

    return dao.processNextReservation();
}
}
