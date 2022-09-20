package main;

import enumm.Gender;
import exception.CompanyNotFoundException;
import exception.PriceException;
import model.*;
import repository.MemoryArrayCompanyRepository;
import repository.MemoryListCompanyRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        Date date2 = new Date();
        try {
            date = formatter.parse("26-09-2023");
            date2 = formatter.parse("22-09-2022");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        Address compagnyAddress = new Address("Central Avenue", "56", "4000", "New York", "USA", "41");
        Session session0 = new PublicSession(new Course("Java", new Company("Boring", compagnyAddress)));
        Session session1 = new CompanySession(new Course("Fencing", new Company("Olympic committee", compagnyAddress)), new Company("Blacksmith", compagnyAddress), new Company("Tensen", compagnyAddress));
        Session session2 = new CompanySession(new Course("neural network", date, new Company("Nintendo", compagnyAddress), new Person("Bob", "Janssens", 57, Gender.OTHER)), new Company("Sony", compagnyAddress), new Company("Volvo", compagnyAddress), new ArrayList<Person>(){{
            add(new Person("Peter", "Parker", 18, Gender.MALE));
            add(new Person("Mary", "Jane", 21, Gender.FEMALE));
            add(new Person("Gwen", "Stacy", 18, Gender.FEMALE));
            add(new Person("Harry", "Potter", 33, Gender.OTHER));
        }});
        Session[] sessions = new Session[]{session0, session1, session2};
        // Arrays.stream(sessions).forEach(Session::printInfo);
        // System.out.println();
        Arrays.stream(new Service[]{
                session0, session2, new Service()
        }).forEach(Service::calculatePrice);
        System.out.println();
        Arrays.stream(new Service[]{
                session0, session1, new Service()
        }).forEach(Main::printServiceInfo);
        try {
            //session2.getOrganizer().requestPriceOfferForCompanySession(new Course("Fencing", date, "Olympic committee"), 10);
            session2.getOrganizer().requestPriceOfferForCompanySession(new Course("Fencing", date2,  new Company("Olympic Committee", compagnyAddress)), 2);
        } catch(PriceException e) {
          e.printStackTrace();
        }

        MemoryListCompanyRepository macl = new MemoryListCompanyRepository(new String[]{"one", "nintendo", "sony", "playstation", "bing"});
        MemoryArrayCompanyRepository macr = new MemoryArrayCompanyRepository(new String[]{"one", "nintendo", "sony", "playstation", "bing"});
        try {
            macl.findCompany("playstation");
            macr.findCompany("xbox");
        } catch(CompanyNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printServiceInfo(Service service) {
        service.calculatePrice();
        if (service instanceof Session)
            ((Session)service).printInfo();
    }

}
