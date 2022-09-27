package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class CompanySession extends Session {

    private List<Person> participants;
    private Company sponsor;
    private static double dailyPrice = 16.0;
    public CompanySession(Course course, Company orgCompany, Company sponsorName, LocalDate startDate) {
        super(course, orgCompany, startDate);
        this.sponsor = sponsorName;
    }

    public CompanySession(Course course, Company orgCompany, Company sponsorName, LocalDate startDate, List<Person> participants) {
        this(course, orgCompany, sponsorName, startDate);
        this.participants = participants;
    }

    public CompanySession(Course course, Company orgCompany, Company sponsorName, LocalDate startDate, int amountParticipants) {
        this(course, orgCompany, sponsorName, startDate, Arrays.asList(new Person[amountParticipants]));
    }

    public void printInfo() {
        super.printInfo();
        System.out.print("This session is offered to you by " + this.sponsor.getName() + ". ");
        if (this.participants != null && this.participants.size() > 0)
            System.out.println("There will be " + this.participants.size() + " participants.");
    }

    @Override
    public double calculatePrice() {
        double price = 0.0;

        int participantsCount = this.participants != null ? this.participants.size() : 1;
        long dayDiff = Math.abs(LocalDate.now().until(this.getCourse().getStartTime(), ChronoUnit.DAYS));
        price = dayDiff * dailyPrice * participantsCount;


        System.out.println("The price for the " + this.getClass().getSimpleName() + " is " + price);
        return price;
    }

    public List<Person> getParticipants() {
        return participants;
    }
}
