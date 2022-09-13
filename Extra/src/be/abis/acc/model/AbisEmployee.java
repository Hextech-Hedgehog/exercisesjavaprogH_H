package be.abis.acc.model;

public class AbisEmployee extends Person {

    private double salary;
    private Address home;

    public AbisEmployee(String firstName, String lastName, int age, int personId, double salary, Address home, String company, Address companyAddress) {
        super(firstName, lastName, age, personId, company, companyAddress);
        this.salary = salary;
        this.home = home;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getHome() {
        return home;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(" Has a montlhy income of " + this.salary + ". Home address: ");
        this.home.printInfo();
    }
}
