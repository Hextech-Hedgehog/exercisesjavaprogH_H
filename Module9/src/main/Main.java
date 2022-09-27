package main;

import enumm.Gender;
import model.*;
import repository.Calculator;
import exception.utils.CalculatorUtils;
import exception.utils.DateUtils;
import repository.CourseParticipant;
import service.AbisEnrolmentService;

import java.time.LocalDate;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        LocalDate date = DateUtils.parse("25-09-1996");
        Address companyAddress = new Address("Wayne avenue", "33", "5000", "Gotham city", "USA", "50");
        Company company = new Company("Atlas", companyAddress);
        Course course = new Course("Base jumping", date, company);


        BiFunction<Integer, Double, Double> calculatePrice = (price, reduction) -> price - (price * reduction);
        System.out.println(course.calculateTotalPrice(90, 0.15));
        System.out.println(calculatePrice.apply(90, 0.15));
        System.out.println(course.calculateTotalPrice(90, 0.15, calculatePrice));

        Calculator c = (int i, double d) -> i - (i * d);
        System.out.println(CalculatorUtils.callCalculator(c, 90, 0.15));

        Session publicSession = new PublicSession(new Course("Java", date, new Company("Oracle", companyAddress)), date);
        CourseParticipant participant = new Person("Johny", "English", 54, Gender.MALE, new Company("spaceX", companyAddress));
        CourseParticipant[] participants = {new Person("Peter", "Parker", 24, Gender.MALE, new Company("ABIS", companyAddress)),
                new Person("Gwen", "Stacy", 22, Gender.FEMALE, new Company("Revx", companyAddress)),
                new Person("Mary", "Jane", 23, Gender.FEMALE, new Company("ABIS", companyAddress))};
        ((PublicSession)publicSession).addEnrolment(participant);
        ((PublicSession)publicSession).addEnrolments(participants);
        AbisEnrolmentService aes = new AbisEnrolmentService((PublicSession)publicSession);

        System.out.println("unsorted list of particpants");
        aes.getPublicSession().printParticipantList();

        System.out.println();
        System.out.println("Sorted list of participants by firstname");
        aes.sortPublicSessionParticipantsByFirstname();
        aes.getPublicSession().printParticipantList();

        System.out.println();
        System.out.println("Sorted list of participants by lastname");
        aes.sortPublicSessionParticipantsByLastname();
        aes.getPublicSession().printParticipantList();

        System.out.println();
        System.out.println("Sorted list of participants by firstname + lastname");
        aes.sortPublicSessionParticipantsByNameCombination();
        aes.getPublicSession().printParticipantList();

        System.out.println();
        System.out.println("Sorted list of participants by id");
        aes.sortPublicSessionParticipantsById();
        aes.getPublicSession().printParticipantList();
    }

}
