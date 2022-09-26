package main;

import enumm.Gender;
import exception.CompanyNotFoundException;
import model.*;
import repository.CourseParticipant;
import repository.MemoryArrayCompanyRepository;
import repository.MemoryListCompanyRepository;
import service.AbisCompanyService;
import service.CompanyComparatorByName;
import utils.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Address compagnyAddress = new Address("Central Avenue", "56", "4000", "New York", "USA", "41");
        Person harry = new Person("Harry", "Potter", 23, Gender.OTHER, new Company("Ministry of magic", compagnyAddress));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        Date date2 = new Date();
        LocalDate date3 = DateUtils.parse("23-11-2022");

        try {
            date = formatter.parse("26-09-2023");
            date2 = formatter.parse("22-09-2022");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        harry.addHobby("Fencing");
        harry.addHobbies("Fencing", "sky diving", "reading", "watching movies");

        //String name, Date startTime, Company company, Person instructor
        Session publicSession = new PublicSession(new Course("Java", date, new Company("Oracle", compagnyAddress), harry), date3);
        CourseParticipant participant = new Person("Johny", "English", 54, Gender.MALE, new Company("spaceX", compagnyAddress));
        CourseParticipant[] participants = {new Person("Peter", "Parker", 24, Gender.MALE, new Company("ABIS", compagnyAddress)),
                new Person("Gwen", "Stacy", 22, Gender.FEMALE, new Company("Revx", compagnyAddress)),
                new Person("Mary", "Jane", 23, Gender.FEMALE, new Company("ABIS", compagnyAddress))};
        ((PublicSession)publicSession).addEnrolment(participant);
        ((PublicSession)publicSession).addEnrolments(participants);
        ((PublicSession)publicSession).printParticipantList();
        publicSession.printInfo();
    }

    public static void printServiceInfo(Service service) {
        service.calculatePrice();
        if (service instanceof Session)
            ((Session)service).printInfo();
    }

}
