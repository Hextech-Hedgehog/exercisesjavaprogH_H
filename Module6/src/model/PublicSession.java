package model;

import repository.CourseParticipant;

import java.util.Arrays;
import java.util.List;

public class PublicSession extends Session {

    List<CourseParticipant> enrolments;

    public PublicSession(Course course) {
        super(course, "ABIS");
    }

    @Override
    public double calculatePrice() {
        double price = 300.0;
        System.out.println("The price for the " + this.getClass().getSimpleName() + " is " + price);
        return price;
    }

        /* addEnrolment() to do 1 enrolment
        - addEnrolments() using a varargs in case you want to do multiple enrolments at once
        - cancelEnrolment() to remove a person from the list */

    public void addEnrolment(CourseParticipant person) {
        enrolments.add(person);
    }

    public void addEnrolments(CourseParticipant ... persons) {
        enrolments.addAll(Arrays.asList(persons));
    }

    public void cancelEnrolment(CourseParticipant person) {
        enrolments.remove(person);
    }

    public void printParticipantList() {
        //enrolments.forEach(Person::);
    }
}
