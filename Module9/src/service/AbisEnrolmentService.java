package service;

import model.Person;
import model.PublicSession;
import repository.CourseParticipant;

import java.util.Collections;
import java.util.Comparator;

public class AbisEnrolmentService implements EnrolmentService {

    private PublicSession publicSession;

    public AbisEnrolmentService(PublicSession publicSession) {
        this.publicSession = publicSession;
    }

    public PublicSession getPublicSession() {
        return publicSession;
    }

    public void sortPublicSessionParticipantsByFirstname () {
        Comparator<CourseParticipant> compareByName = new Comparator<CourseParticipant>() {
            @Override
            public int compare(CourseParticipant c1, CourseParticipant c2) {
                Person p1 = (Person)c1;
                Person p2 = (Person)c2;
                return p1.getFirstName().compareTo(p2.getFirstName());
            }
        };
        // with anonymous class
        this.getPublicSession().getEnrolments().sort(compareByName);

        // with lambda
        Comparator compa = Comparator.comparing(Person::getFirstName);
        this.getPublicSession().getEnrolments().sort(compa);
        this.getPublicSession().getEnrolments().sort(Comparator.comparing((CourseParticipant p) -> ((Person)p).getFirstName()));
    }

    public void sortPublicSessionParticipantsByLastname() {
        this.getPublicSession().getEnrolments().sort(Comparator.comparing((CourseParticipant p) -> ((Person)p).getLastName()));
    }

    public void sortPublicSessionParticipantsByNameCombination() {
        this.getPublicSession().getEnrolments().sort(Comparator.comparing((CourseParticipant p) -> ((Person)p).getFirstName() + ((Person)p).getLastName()));
    }

    public void sortPublicSessionParticipantsById() {
        Collections.sort(this.getPublicSession().getEnrolments());
    }

}
