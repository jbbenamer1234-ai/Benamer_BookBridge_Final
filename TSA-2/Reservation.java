

public class Reservation {

    private Member member;
    private LibraryBook book;

    public Reservation(Member member, LibraryBook book) {
        this.member = member;
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public LibraryBook getBook() {
        return book;
    }
}