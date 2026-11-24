
public abstract class Member implements Notifiable {

    private String memberId;
    private String name;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public abstract int getMaximumLoanDays();

    public abstract double getDailyFine();

    @Override
    public void notifyMember() {
        System.out.println("Notification sent to " + name);
    }
}
