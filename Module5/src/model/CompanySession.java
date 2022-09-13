package model;

import exception.PriceTooHighException;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CompanySession extends Session {

    private List<Person> participants;
    private Company sponsor;
    private static double dailyPrice = 16.0;
    public CompanySession(Course course, String orgCompany, String sponsorName) {
        super(course, orgCompany);
        this.sponsor = new Company(sponsorName);
    }

    public CompanySession(Course course, String orgCompany, String sponsorName, List<Person> participants) {
        this(course, orgCompany, sponsorName);
        this.participants = participants;
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

        try {
            int participantsCount = this.participants != null ? this.participants.size() : 1;
            Date date = new Date();
            long timeDiff = Math.abs(date.getTime() - this.getCourse().getStartTime().getTime());
            long dayDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
            price = dayDiff * dailyPrice * participantsCount;
            if (price > 3000.0) {
                throw new PriceTooHighException("Price too high exception. Price is " + price + ". Price musn't be greater than " + 3000.0);
            }
        } catch(PriceTooHighException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("The price for the " + this.getClass().getSimpleName() + " is " + price);
        return price;
    }
}
