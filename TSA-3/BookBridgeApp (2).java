import java.util.*;

public class BookBridgeApp {

    public static void main(String[] args) {

        Map<String, LibraryBook> books =
                new HashMap<>();

        Map<String, Member> members =
                new HashMap<>();

        Map<String, LoanRecord> activeLoans =
                new HashMap<>();

        Queue<Reservation> reservations =
                new LinkedList<>();

        Set<String> checkedOutBooks =
                new HashSet<>();

        List<LoanRecord> loanHistory =
                new ArrayList<>();

        LibraryBook book =
                new LibraryBook(
                        "978001",
                        "Java Basics"
                );

        books.put(
                book.getIsbn(),
                book
        );

        Member student =
                new Student(
                        "S001",
                        "Juan"
                );

        members.put(
                student.getMemberId(),
                student
        );

        LoanRecord loan =
                new LoanRecord(
                        student,
                        book
                );

        activeLoans.put(
                String.valueOf(
                        loan.getLoanId()
                ),
                loan
        );

        loanHistory.add(loan);

        checkedOutBooks.add(
                book.getIsbn()
        );

        Reservation reservation =
                new Reservation(
                        student,
                        book
                );

        reservations.offer(
                reservation
        );

        System.out.println(
                "Books: "
                + books.size()
        );

        System.out.println(
                "Members: "
                + members.size()
        );

        System.out.println(
                "Loans: "
                + activeLoans.size()
        );

        System.out.println(
                "Reservations: "
                + reservations.size()
        );

        System.out.println(
                "Checked Out: "
                + checkedOutBooks.size()
        );
    }
}