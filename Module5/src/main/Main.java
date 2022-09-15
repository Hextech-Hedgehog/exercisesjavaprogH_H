package main;

import courseadmin.repository.MemoryArrayCompanyRepository;
import enumm.Gender;
import exception.CompanyNotFoundException;
import exception.PriceException;
import exception.PriceTooHighException;
import exception.PriceTooLowException;
import model.*;

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
        Session session0 = new PublicSession(new Course("Java", "Boring"));
        Session session1 = new CompanySession(new Course("Fencing", "Olympic committee"), "Blacksmiths", "Tensen");
        Session session2 = new CompanySession(new Course("neural network", date, "Nintendo", new Person("Bob", "Janssens", Gender.OTHER)), "Sony", "Volvo", new ArrayList<>(){{
            add(new Person("Peter", "Parker", Gender.MALE));
            add(new Person("Mary", "Jane", Gender.FEMALE));
            add(new Person("Gwen", "Stacy", Gender.FEMALE));
            add(new Person("Harry", "Potter", Gender.OTHER));
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
            session2.getOrganizer().requestPriceOfferForCompanySession(new Course("Fencing", date2, "Olympic committee"), 2);
        } catch(PriceException e) {
          e.printStackTrace();
        }

        MemoryArrayCompanyRepository macr = new MemoryArrayCompanyRepository(new String[]{"one", "nintendo", "sony", "playstation", "bing"});
        try {
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
