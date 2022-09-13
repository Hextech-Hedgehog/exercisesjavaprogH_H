package be.abis.courseadmin.test;

import be.abis.courseadmin.model.*;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Course course = new Course("Fencing", 30, 7.44);
        Company company = new Company("Neuralink");
        course.printInfo();
        System.out.println(course.calculateTotalPrice());
        company.printInfo();
        testing();

        Person[] persons = new Person[]{
                new Person("Mary", "Jane", new Company("SpaceX")),
                new Person("Peter", "Parker")
        };
        Person.printTotalPersons();
        Arrays.stream(persons).forEach(Person::printInfo);
        persons[0].attendCourse(course);
        persons[0].addHobbies("Reading", "Running", "sky diving");
    }

    public static void testing() {
        String[] strArr1 = new String[]{"apple", "ananas", "dragon-pie"};
        String[] strArr2 = Arrays.stream(strArr1).toArray(String[]::new);
        strArr2[1] = "banana";
        Arrays.stream(strArr1).forEach(System.out::println);
    }

}
