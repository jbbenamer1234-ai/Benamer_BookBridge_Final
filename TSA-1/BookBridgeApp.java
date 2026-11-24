import java.util.Scanner;

public class BookBridgeApp {

    static final int MAX_REQUESTS = 5;

    static String[] memberIds = new String[MAX_REQUESTS];
    static String[] memberNames = new String[MAX_REQUESTS];
    static String[] membershipTypes = new String[MAX_REQUESTS];
    static String[] isbns = new String[MAX_REQUESTS];
    static String[] bookTitles = new String[MAX_REQUESTS];
    static int[] requestedDaysArr = new int[MAX_REQUESTS];
    static String[] outcomes = new String[MAX_REQUESTS];
    static double[] lateFees = new double[MAX_REQUESTS];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int approvedCount = 0;
        int reservedCount = 0;
        int deniedCount = 0;

        int highestDays = 0;
        String highestBook = "";

        double totalLateFees = 0;

        System.out.println("=== BOOKBRIDGE TSA1 ===");

        for (int i = 0; i < MAX_REQUESTS; i++) {

            System.out.println("\nTransaction #" + (i + 1));

            String memberId;
            String memberName;
            String membershipType;
            String isbn;
            String bookTitle;
            int requestedDays;
            boolean available;
            int lateDays;

            do {
                System.out.print("Member ID: ");
                memberId = sc.nextLine().trim();
            } while (memberId.isEmpty());

            do {
                System.out.print("Member Name: ");
                memberName = sc.nextLine().trim();
            } while (memberName.isEmpty());

            do {
                System.out.print("Membership Type (STUDENT/FACULTY/GUEST): ");
                membershipType = sc.nextLine().trim().toUpperCase();
            } while (!validateMembershipType(membershipType));

            do {
                System.out.print("ISBN: ");
                isbn = sc.nextLine().trim();
            } while (isbn.isEmpty());

            do {
                System.out.print("Book Title: ");
                bookTitle = sc.nextLine().trim();
            } while (bookTitle.isEmpty());

            do {
                System.out.print("Requested Loan Days (1-30): ");
                requestedDays = sc.nextInt();
            } while (requestedDays < 1 || requestedDays > 30);

            System.out.print("Book Available? (true/false): ");
            available = sc.nextBoolean();

            do {
                System.out.print("Late Days: ");
                lateDays = sc.nextInt();
            } while (lateDays < 0);

            sc.nextLine();

            String result = classifyRequest(
                    available,
                    requestedDays,
                    getMaximumDays(membershipType));

            double fee =
                    lateDays *
                    getDailyFine(membershipType);

            memberIds[i] = memberId;
            memberNames[i] = memberName;
            membershipTypes[i] = membershipType;
            isbns[i] = isbn;
            bookTitles[i] = bookTitle;
            requestedDaysArr[i] = requestedDays;
            outcomes[i] = result;
            lateFees[i] = fee;

            if (result.equals("APPROVED")) {
                approvedCount++;
            } else if (result.equals("RESERVED")) {
                reservedCount++;
            } else {
                deniedCount++;
            }

            if (requestedDays > highestDays) {
                highestDays = requestedDays;
                highestBook = bookTitle;
            }

            totalLateFees += fee;

            System.out.println("\n--- RESULT ---");
            System.out.println("Outcome: " + result);
            System.out.println("Late Fee: PHP " + fee);
        }

        printSummary(
                approvedCount,
                reservedCount,
                deniedCount,
                highestBook,
                highestDays,
                totalLateFees);
    }

    public static boolean validateMembershipType(
            String membershipType) {

        return membershipType.equals("STUDENT")
                || membershipType.equals("FACULTY")
                || membershipType.equals("GUEST");
    }

    public static int getMaximumDays(
            String membershipType) {

        switch (membershipType) {

            case "STUDENT":
                return 14;

            case "FACULTY":
                return 30;

            case "GUEST":
                return 7;

            default:
                return 0;
        }
    }

    public static double getDailyFine(
            String membershipType) {

        switch (membershipType) {

            case "STUDENT":
                return 5;

            case "FACULTY":
                return 2;

            case "GUEST":
                return 10;

            default:
                return 0;
        }
    }

    public static String classifyRequest(
            boolean available,
            int requestedDays,
            int maxDays) {

        if (!available) {
            return "RESERVED";
        }

        if (requestedDays <= maxDays) {
            return "APPROVED";
        }

        return "DENIED";
    }

    public static void printSummary(
            int approved,
            int reserved,
            int denied,
            String highestBook,
            int highestDays,
            double totalFees) {

        System.out.println("\n====================");
        System.out.println("FINAL SUMMARY");
        System.out.println("====================");
        System.out.println("Approved: " + approved);
        System.out.println("Reserved: " + reserved);
        System.out.println("Denied: " + denied);
        System.out.println("Highest Requested Days: "
                + highestBook + " (" + highestDays + ")");
        System.out.println("Total Late Fees: PHP "
                + totalFees);
    }
}
