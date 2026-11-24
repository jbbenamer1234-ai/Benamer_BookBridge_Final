

public class LoanRecord {

    private static int counter = 1;

    private int loanId;
    private Member member;
    private LibraryBook book;

    public LoanRecord(Member member, LibraryBook book) {
        this.loanId = counter++;
        this.member = member;
        this.book = book;
    }

    public int getLoanId() {
        return loanId;
    }

    public Member getMember() {
        return member;
    }

    public LibraryBook getBook() {
        return book;
    }
}