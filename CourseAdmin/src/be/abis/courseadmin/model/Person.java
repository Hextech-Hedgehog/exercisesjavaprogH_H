package be.abis.courseadmin.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {

    private String firstName, lastName;
    private Company company;
    private final int personnalId;
    private List<String> hobbies = new ArrayList();
    public static int counter = 0;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personnalId = this.counter;
        this.counter++;
    }

    public Person(String firstName, String lastName, Company company) {
        this(firstName, lastName);
        this.company = company;
    }

    public List<String> getHobbies() {
        return this.hobbies;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void printInfo() {
        String personalId = ". Personal ID: " + this.personnalId;
        if (this.company == null)
            System.out.println(this.firstName + " is not linked to a company at the moment" + personalId);
        else
            System.out.println(this.firstName + " works for " + this.company + personalId);
    }

    public static void printTotalPersons() {
        System.out.println("There are currently: " + Person.counter + " persons.");
    }

    public void attendCourse(Course course) {
        System.out.println(this.firstName + " is attending a " + course.getTitle() + " course.");
    }

    public void addHobby(String hobby) {
        this.hobbies.add(hobby);
    }

    public void addHobbies(String... hobbies) {
        this.hobbies.addAll(Arrays.asList(hobbies));
    }

    public void displayHobbies() {
        for (String hobby: this.hobbies) {
            System.out.println(hobby);
        }
    }
}
