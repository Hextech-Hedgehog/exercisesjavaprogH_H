package model;

import enumm.Gender;

public class Person {

    private String firstName, lastName;
    private Gender gender;

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
}
