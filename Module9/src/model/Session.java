package model;

import exception.utils.DateUtils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.Locale;

public abstract class Session extends Service {

    private LocalDate startDate;
    private Course course;
    private Company organizer;

    public Session(Course course, Company company, LocalDate startDate) {
        this.course = course;
        this.organizer = company;
        this.startDate = startDate;
    }

    public LocalDate getStartDate() { return this.startDate; }

    public Course getCourse() {
        return this.course;
    }

    public Company getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Company company) {
        this.organizer = company;
    }

    public void printInfo() {
        System.out.println(this.getClass().getSimpleName() + " starts at " + DateUtils.format(this.startDate));
        String price = new DecimalFormat("#,###.##", new DecimalFormatSymbols(Locale.ITALIAN)).format(calculatePrice());
        System.out.println(this.getClass().getSimpleName() + ": " + price);
        System.out.print("The " + this.getCourse().getName() + " course will start on " + this.getCourse().getStartTime().toString() + ".");
        System.out.println(" It will take place at " + this.getOrganizer().getName() + ".");
        System.out.println(this.getCourse());
    }

    @Override
    public double calculatePrice() {
        double price = 1300.0;
        // System.out.println("The price for the " + this.getClass().getSimpleName() + " is " + price);
        return price;
    }

}