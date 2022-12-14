package model;

import courseadmin.repository.CourseParticipant;
import courseadmin.repository.Instructor;
import enumm.Gender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person implements Instructor, CourseParticipant {

    private String firstName;
    private String lastName;
    private Gender gender;
    private List<String> hobbies = new ArrayList();
    private int age;
    private Company company;
    private Course course;

    public Person(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Person(String firstName, String lastName, int age, Gender gender, Company company) {
        this(firstName, lastName, age, gender);
        this.company = company;
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

    public List<String> getHobbies() {
        return hobbies;
    }

    public void displayHobbies() {
        for (String hobby: this.hobbies) {
            System.out.println(hobby);
        }
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
}
