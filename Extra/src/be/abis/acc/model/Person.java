package be.abis.acc.model;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private final int personId;
    private Company company;

    public Person(String firstName, String lastName, int age, int personId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.personId = personId;
    }

    public Person(String firstName, String lastName, int age, int personId, String company, Address companyAddress) {
        this(firstName, lastName, age, personId);
        this.company = new Company(company, companyAddress);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPersonId() {
        return personId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Person: " + this.personId + ". Named: " + this.firstName + ". Of age: " + this.age;
    }

    public int calculateAge() {
        return this.age;
    }

    public void printInfo() {
        System.out.print("Person " + this.personId + ": "+ this.firstName + " " + this.lastName);
        System.out.print(" (" + this.age + " years old)");
        if (this.company != null)
            System.out.println(" works for " + this.company.getName() + " in " + this.company.getAddress().getTown());
        else
            System.out.println(" is not employed for the moment");
    }
}
