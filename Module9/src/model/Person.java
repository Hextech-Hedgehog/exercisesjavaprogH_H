package model;

import enumm.Gender;
import repository.CourseParticipant;
import repository.Instructor;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Person implements Instructor, CourseParticipant {

    private String firstName;
    private String lastName;
    private Gender gender;
    private Set<String> hobbies = new TreeSet<>();
    private int age;
    private Company company;
    private Course course;
    private static int personNumber = 0;
    private int personId = personNumber++;

    public Person(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public Person(String firstName, String lastName, int age, Gender gender, Company company) {
        this(firstName, lastName, age, gender);
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public Company getCompany() {
        return company;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGenderAbbreviation() {
        return this.gender.getAbbreviation();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return this.getGenderAbbreviation() + " " + this.firstName;
    }

    public void addHobby(String hobby) {
        this.hobbies.add(hobby);
    }

    public void addHobbies(String... hobbies) {
        this.hobbies.addAll(Arrays.asList(hobbies));
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    public void displayHobbies() {
        for (String hobby: this.hobbies) {
            System.out.println(hobby);
        }
    }

    public int calculateAge() {
        return this.age;
    }

    public void printInfo() {
        System.out.print("Person: "+ this.firstName + " " + this.lastName);
        System.out.print(" (" + this.age + " years old)");
        if (this.company != null)
            System.out.println(" works for " + this.company.getName() + " in " + this.company.getAddress().getTown());
        else
            System.out.println(" is not employed for the moment");
    }

    @Override
    public void attendCourse(Course course) {
        this.course = course;
        System.out.println(this.firstName + " is attending " + this.course.getName() + " course.");
    }

    @Override
    public void teachCourse(Course course) {
        course.setInstructor(this);
        System.out.println(this.firstName + " is teaching " + this.course.getName() + " course.");
    }

    public boolean worksForAbis() {
        return this.getCompany().getName().equalsIgnoreCase("ABIS");
    }

    @Override
    public int compareTo(CourseParticipant cop) {
        Person p = (Person)cop;
        if (this.personId > p.personId) {
            return -1;
        } else if (this.personId < p.personId)
            return 1;
        return 0;
    }
}
