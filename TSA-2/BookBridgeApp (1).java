

public class BookBridgeApp {

    public static void main(String[] args) {

        LibraryBook book =
                new LibraryBook(
                        "978001",
                        "Java Basics"
                );

        Member student =
                new Student(
                        "S001",
                        "Juan"
                );

        Member faculty =
                new Faculty(
                        "F001",
                        "Maria"
                );

        LibraryService service =
                new LibraryService();

        System.out.println(
                service.classifyRequest(
                        student,
                        book,
                        10
                )
        );

        System.out.println(
                service.classifyRequest(
                        faculty,
                        book,
                        25
                )
        );

        LoanRecord loan =
                new LoanRecord(
                        student,
                        book
                );

        Reservation reservation =
                new Reservation(
                        faculty,
                        book
                );

        System.out.println(
                "Loan ID: "
                + loan.getLoanId()
        );

        System.out.println(
                "Reserved by: "
                + reservation.getMember().getName()
        );

        System.out.println("\n--- POLYMORPHISM TEST ---");

        PolymorphismTest.runTest();
    }
}