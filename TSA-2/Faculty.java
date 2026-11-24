
public class Faculty extends Member {

    public Faculty(String memberId, String name) {
        super(memberId, name);
    }

    @Override
    public int getMaximumLoanDays() {
        return 30;
    }

    @Override
    public double getDailyFine() {
        return 2;
    }
}