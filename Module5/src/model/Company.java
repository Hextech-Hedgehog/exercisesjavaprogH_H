package model;

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
}
