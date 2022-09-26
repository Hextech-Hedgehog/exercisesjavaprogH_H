package model;

import repository.CourseParticipant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class PublicSession extends Session {

    public List<CourseParticipant> enrolments = new ArrayList<>();

    public PublicSession(Course course) {
        super(course, new Company("ABIS", new Address()));
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
        enrolments.forEach(CourseParticipant::printInfo);
    }

    public List<CourseParticipant> findAbisParticipants() {
        return this.enrolments.stream().filter(p -> ((Person)p).worksForAbis()).toList();
    }

    public void removeAbisParticipant() {
        Iterator it = this.enrolments.iterator();
        while (it.hasNext()) {
            if (((Person)it.next()).worksForAbis()) {
                it.remove();
            }
        }
    }
}
