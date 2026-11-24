/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookbridge.model;

/**
 *
 * @author Juan Benamer
 */
public class Loan {

    private int loanId;
    private int memberId;
    private int bookId;

    public Loan(int loanId, int memberId, int bookId) {
        this.loanId = loanId;
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public int getLoanId() {
        return loanId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getBookId() {
        return bookId;
    }
}
