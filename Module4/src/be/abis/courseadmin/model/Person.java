package be.abis.courseadmin.model;

import be.abis.courseadmin.enumm.Gender;
import be.abis.courseadmin.repository.CourseParticipant;
import be.abis.courseadmin.repository.Instructor;

public class Person implements Instructor, CourseParticipant {

    private String firstName, lastName;
    private Gender gender;
    private Course course;

    public Person(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Person(Person person) {
        this(person.getFirstName(), person.getLastName(), person.gender);
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
