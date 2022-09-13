package be.abis.courseadmin.model;

public class Company {

    private String name;

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
        return this.name;
    }
}
