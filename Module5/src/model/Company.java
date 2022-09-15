package model;

import exception.PriceException;
import exception.PriceTooHighException;
import exception.PriceTooLowException;

public class Company {

    private String name;
    private static int companyCount = 0;
    private final int companyNumber = companyCount++;

    public Company(String name) {
        this.name = name;
    }

    public Company(Company company) {
        this(company.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("Company name: " + this.name);
    }

    public String toString() {
        return "Company name: " + this.name;
    }

    public void requestPriceOfferForCompanySession(Course c, int numberOfParticipants) throws PriceException {
        CompanySession cs = new CompanySession(c, "ABIS", this.name, numberOfParticipants);
        double price = cs.calculatePrice();
        if (price > 3000.0) {
            throw new PriceTooHighException("Price too high exception. Price is " + price + ". Price musn't be greater than " + 3000.0);
        } else if (price < 200) {
            throw new PriceTooLowException("Price too low exception. Price is " + price + ". Price musn't be lower than " + 200.0);
        }
        System.out.println("number of participants: " + cs.getParticipants().size());
    }
}
