package model;

import exception.PriceException;
import exception.PriceTooHighException;
import exception.PriceTooLowException;

public class Company implements Comparable<Company> {

    private String name;
    private static int companyCount = 0;
    private final int companyNumber = companyCount++;
    private Address address;

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return this.address;
    }

    public void printInfo() {
        System.out.println("Company name: " + this.name);
    }

    public String toString() {
        return "Company name: " + this.name;
    }

    public void requestPriceOfferForCompanySession(Course c, int numberOfParticipants) throws PriceException {
        CompanySession cs = new CompanySession(c, new Company("Abis", new Address("a", "a","a","a","a","a")), this, numberOfParticipants);
        double price = cs.calculatePrice();
        if (price > 3000.0) {
            throw new PriceTooHighException("Price too high exception. Price is " + price + ". Price musn't be greater than " + 3000.0);
        } else if (price < 200) {
            throw new PriceTooLowException("Price too low exception. Price is " + price + ". Price musn't be lower than " + 200.0);
        }
        System.out.println("number of participants: " + cs.getParticipants().size());
    }

    @Override
    public int compareTo(Company c) {
        if (this.getCompanyNumber() == c.getCompanyNumber())
            return 0;
        else if (this.getCompanyNumber() > c.getCompanyNumber())
            return -1;
        return 1;
    }
}
