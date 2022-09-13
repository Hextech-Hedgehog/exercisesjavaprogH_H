package be.abis.courseadmin.main;

import be.abis.courseadmin.enumm.Gender;
import be.abis.courseadmin.model.*;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Session session0 = new PublicSession(new Course("Java", "Boring"));
        Session session1 = new CompanySession(new Course("Fencing", "Olympic committee"), "Blacksmiths", "Tensen");
        Session session2 = new CompanySession(new Course("neural network", new Date(), "Nintendo", new Person("Bob", "Janssens", Gender.OTHER)), "Sony", "Volvo", new ArrayList<>(){{
            add(new Person("Peter", "Parker", Gender.MALE));
            add(new Person("Mary", "Jane", Gender.FEMALE));
            add(new Person("Gwen", "Stacy", Gender.FEMALE));
        }});
        Session[] sessions = new Session[]{session0, session1, session2};
        Arrays.stream(sessions).forEach(Session::printInfo);
        System.out.println();
        Arrays.stream(new Service[]{
                session0, session1, new Consultancy(), new Service()
        }).forEach(Service::calculatePrice);
        Arrays.stream(new Service[]{
                session0, session1, new Consultancy(), new Service()
        }).forEach(Main::printServiceInfo);
        //testSpeed();
        Course pythonCourse = new Course("Python", new Date(), "Udemy");
        Person emilia = new Person("Emilia", "Clarke", Gender.FEMALE);
        emilia.attendCourse(pythonCourse);
        emilia.teachCourse(pythonCourse);
    }

    public static void printServiceInfo(Service service) {
        service.calculatePrice();
        if (service instanceof Session)
            ((Session)service).printInfo();
    }

    public static void testSpeed() {
        MemoryArrayCompanyRepository macr = new MemoryArrayCompanyRepository(new String[]{"one", "nintendo", "sony", "playstation", "bing"});
        macr.findCompany("playstation");
    }

}
