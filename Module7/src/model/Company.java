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

    @Override
    public int compareTo(Company c) {
        if (this.getCompanyNumber() == c.getCompanyNumber())
            return 0;
        else if (this.getCompanyNumber() > c.getCompanyNumber())
            return -1;
        return 1;
    }
}
