package be.abis.acc.test;

import be.abis.acc.model.AbisEmployee;
import be.abis.acc.model.Address;
import be.abis.acc.model.Person;
import be.abis.acc.model.Course;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Address gotham = new Address("Thomas boulevard", "7", "5000", "Gotham", "USA", "50");
        Address metropolis = new Address("Roosevelt avenue", "56", "1200", "Metropolis", "USA", "50");
        Person person1 = new Person("Clark", "Kent", 33, 1001, "The daily mail", metropolis);
        Person person2 = new Person("Bruce", "Wayne", 36, 1, "Wayne Enterprise", gotham);
        Person person3 = new Person("John", "Doe", 37, 666);
        Person persons[] = {person1, person2, person3};
        displayPeoplesNames(persons);
        Address address = new Address("Wayne avenue", "10", "200", "sim city", "Phillipines", "57");
        AbisEmployee employee = new AbisEmployee("Jeff", "Chun", 33, 20, 3000.0, new Address("Corridor avenue", "5", "1000", "Paris", "Phillipines", "57"), "Wayne enterprise", address);
        Course course = new Course("Java", 2, 120, true, new ArrayList<>(){{add(employee);}});
        Course expensiveCourse = new Course("Astronaut", 30, 500, false, new ArrayList<>(){{add(employee);}});
        Course okCourse = new Course("Fencing", 10, 70, true, new ArrayList<>(){{add(employee);}});
        Course[] courses = {course, expensiveCourse, okCourse};
        displayCourses(courses);
        employee.printInfo();
    }

    public static void displayPeoplesNames(Person[] persons) {
        for (Person p : persons)
            p.printInfo();
        //Arrays.stream(persons).forEach(Person::printInfo);
    }

    public static void displayCourses(Course[] courses) {
        for (Course c: courses)
            c.printInfo();
    }

}
