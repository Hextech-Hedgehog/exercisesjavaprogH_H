package model;

import java.util.Date;

public class Course {

    private String name;
    private Date startTime;
    private Company location;
    private Person instructor;

    public Course(String name, String companyName) {
        this(name, new Date(), companyName);
    }

    public Course(String name, Date startTime, String companyName) {
        System.out.println(name);
        this.startTime = startTime;
        this.name = name;
        this.location = new Company(companyName);
    }

    public Course(String name, Date startTime, String companyName, Person instructor) {
        this(name, startTime, companyName);
        if (instructor != null)
            this.instructor = new Person(instructor);
    }

    public Course(Course course) {
        this(course.name, course.startTime, course.location.getName(), course.instructor);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
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
