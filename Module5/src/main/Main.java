package main;

import enumm.Gender;
import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        String date_string = "26-09-2023";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        try {
            date = formatter.parse(date_string);
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
    }

    public static void printServiceInfo(Service service) {
        service.calculatePrice();
        if (service instanceof Session)
            ((Session)service).printInfo();
    }

}
