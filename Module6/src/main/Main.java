package main;

import enumm.Gender;
import exception.CompanyNotFoundException;
import exception.PriceException;
import model.*;
import repository.CourseParticipant;
import repository.MemoryArrayCompanyRepository;
import repository.MemoryListCompanyRepository;
import service.AbisCompanyService;
import service.CompanyComparatorByName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Address compagnyAddress = new Address("Central Avenue", "56", "4000", "New York", "USA", "41");
        Person harry = new Person("Harry", "Potter", 23, Gender.OTHER, new Company("Ministry of magic", compagnyAddress));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        Date date2 = new Date();
        try {
            date = formatter.parse("26-09-2023");
            date2 = formatter.parse("22-09-2022");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        harry.addHobby("Fencing");
        harry.addHobbies("Fencing", "sky diving", "reading", "watching movies");
        //hashset prints : sky diving, fencing, reading, watching movies
        //treeset prints : fencing, reading, sky diving, watching movies (seems alphabetical)
        harry.displayHobbies();

        MemoryListCompanyRepository macl = new MemoryListCompanyRepository(new String[]{"one", "nintendo", "sony", "playstation", "bing"});
        MemoryArrayCompanyRepository macr = new MemoryArrayCompanyRepository(new String[]{"one", "nintendo", "sony", "playstation", "bing"});
        try {
            macl.findCompany("playstation");
            macr.findCompany("xbox");
        } catch(CompanyNotFoundException e) {
            e.printStackTrace();
        }

        //String name, Date startTime, Company company, Person instructor
        Session publicSession = new PublicSession(new Course("Java", date, new Company("Oracle", compagnyAddress), harry));
        CourseParticipant participant = new Person("Johny", "English", 54, Gender.MALE, new Company("spaceX", compagnyAddress));
        CourseParticipant[] participants = {new Person("Peter", "Parker", 24, Gender.MALE, new Company("ABIS", compagnyAddress)),
                new Person("Gwen", "Stacy", 22, Gender.FEMALE, new Company("Revx", compagnyAddress)),
                new Person("Mary", "Jane", 23, Gender.FEMALE, new Company("ABIS", compagnyAddress))};
        ((PublicSession)publicSession).addEnrolment(participant);
        ((PublicSession)publicSession).addEnrolments(participants);
        //((PublicSession)publicSession).cancelEnrolment(participants[0]);
        ((PublicSession)publicSession).printParticipantList();
        System.out.println(((PublicSession)publicSession).findAbisParticipants());
        ((PublicSession)publicSession).removeAbisParticipant();
        System.out.println(((PublicSession)publicSession).findAbisParticipants());

        AbisCompanyService acs = new AbisCompanyService();
        CompanyComparatorByName ccbn = new CompanyComparatorByName();
        System.out.println(acs.getMlcr().getCompanies());
        acs.sortAllCompaniesByName();
        System.out.println(acs.getMlcr().getCompanies());
    }

    public static void printServiceInfo(Service service) {
        service.calculatePrice();
        if (service instanceof Session)
            ((Session)service).printInfo();
    }

}
