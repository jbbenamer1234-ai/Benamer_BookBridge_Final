

public class PolymorphismTest {

    public static void runTest() {

        Member student =
                new Student("S001", "Juan");

        Member faculty =
                new Faculty("F001", "Maria");

        Member guest =
                new Guest("G001", "Pedro");

        Member[] members = {
            student,
            faculty,
            guest
        };

        for (Member member : members) {

            System.out.println(
                    member.getName()
                    + " -> Max Days: "
                    + member.getMaximumLoanDays()
                    + ", Fine: "
                    + member.getDailyFine()
            );
        }
    }
}