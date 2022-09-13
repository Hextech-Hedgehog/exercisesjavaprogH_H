package be.abis.courseadmin.model;

import java.util.ArrayList;
import java.util.List;

public class CompanySession extends Session {

    private List<Person> participants;
    private Company sponsor;

    public CompanySession(Course course, String orgCompany, String sponsorName) {
        super(course, orgCompany);
        this.sponsor = new Company(sponsorName);
    }

    public CompanySession(Course course, String orgCompany, String sponsorName, List<Person> participants) {
        this(course, orgCompany, sponsorName);
        this.participants = participants;
        /*this.participants = new ArrayList<>();
        this.participants.addAll(participants);*/
    }

    public void printInfo() {
        super.printInfo();
        System.out.print("This session is offered to you by " + this.sponsor.getName() + ". ");
        if (this.participants != null && this.participants.size() > 0)
            System.out.println("There will be " + this.participants.size() + " participants.");
    }

    @Override
    public double calculatePrice() {
        double price = 220.0;
        System.out.println("The price for the " + this.getClass().getSimpleName() + " is " + price);
        return price;
    }

}
