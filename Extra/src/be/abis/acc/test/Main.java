package be.abis.acc.test;

import be.abis.acc.model.Address;
import be.abis.acc.model.Person;
import be.abis.acc.model.Course;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Address gotham = new Address("Thomas boulevard", "7", "5000", "Gotham", "USA", "50");
        Address metropolis = new Address("Roosevelt avenue", "56", "1200", "Metropolis", "USA", "50");
        Person person1 = new Person("Clark", "Kent", 33, 1001, "The daily mail", metropolis);
        Person person2 = new Person("Bruce", "Wayne", 36, 1, "Wayne Enterprise", gotham);
        Person person3 = new Person("John", "Doe", 37, 666);
        Person persons[] = {person1, person2, person3};
        displayPeoplesNames(persons);
        Course course = new Course("Java", 2, 120, true);
        Course expensiveCourse = new Course("Astronaut", 30, 500, false);
        Course okCourse = new Course("Fencing", 10, 70, true);
        Course[] courses = {course, expensiveCourse, okCourse};
        displayCourses(courses);
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
