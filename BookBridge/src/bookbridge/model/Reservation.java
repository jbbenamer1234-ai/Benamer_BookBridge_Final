/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookbridge.model;

/**
 *
 * @author Juan Benamer
 */
public class Reservation {

    private int reservationId;
    private int memberId;
    private int bookId;

    public Reservation(int reservationId, int memberId, int bookId) {
        this.reservationId = reservationId;
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getBookId() {
        return bookId;
    }
}