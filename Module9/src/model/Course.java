package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.function.BiFunction;

public class Course {

    private String name;
    private LocalDate startTime;
    private Company location;
    private Person instructor;

    public Course(String name, Company company) {
        this(name, LocalDate.now(), company);
    }

    public Course(String name, LocalDate startTime, Company company) {
        this.startTime = startTime;
        this.name = name;
        this.location = company;
    }

    public Course(String name, LocalDate startTime, Company company, Person instructor) {
        this(name, startTime, company);
        if (instructor != null)
            this.instructor = instructor;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public Company getLocation() {
        return location;
    }

    public void setLocation(Company location) {
        this.location = location;
    }

    public Person getInstructor() {
        return instructor;
    }

    public void setInstructor(Person instructor) {
        this.instructor = instructor;
    }

    public void printInfo() {
        if (this.instructor != null) {
            System.out.print("Your instructor is " + this.getInstructor());
            System.out.println(" of " + this.getLocation().getName());
        } else {
            System.out.println("Course supervised by " + this.getLocation().getName() + " company");
        }
    }

    public double calculateTotalPrice(int price, double reduction) {
        return price - (price * reduction);
    }

    public double calculateTotalPrice(int price, double reduction, BiFunction<Integer, Double, Double> bf) {
        return bf.apply(price, reduction);
    }

    public String toString() {
        String info = "";
        if (this.instructor != null) {
            info += "Your instructor is " + this.getInstructor();
            info += " of " + this.getLocation().getName();
        } else
            info += "Course supervised by " + this.getLocation().getName() + " company";

        return info;
    }
}
