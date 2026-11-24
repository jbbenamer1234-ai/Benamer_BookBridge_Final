

public class Guest extends Member {

    public Guest(String memberId, String name) {
        super(memberId, name);
    }

    @Override
    public int getMaximumLoanDays() {
        return 7;
    }

    @Override
    public double getDailyFine() {
        return 10;
    }
}